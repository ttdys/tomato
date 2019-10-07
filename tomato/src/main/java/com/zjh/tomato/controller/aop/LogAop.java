package com.zjh.tomato.controller.aop;

import com.zjh.tomato.controller.MonitorController;
import com.zjh.tomato.controller.PageController;
import com.zjh.tomato.controller.SysOperLogController;
import com.zjh.tomato.controller.SysUserController;
import com.zjh.tomato.model.SysOperLog;
import com.zjh.tomato.model.SysUser;
import com.zjh.tomato.service.SysOperLogService;
import com.zjh.tomato.utils.LocationUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.servlet.ShiroHttpSession;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 日志 切面类
 *
 * @author zjh
 * @date 2019/9/8 9:50
 */
@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;


    @Autowired
    private SysOperLogService sysOperLogService;


    /**
     * aaa
     */
    private Date visitTime;
    //访问的目标类
    private Class executionClass;
    //访问的目标方法
    private Method executionMethod;

    /**
     * 前置处理
     *
     * @param joinPoint
     */
    @Before("execution(* com.zjh.tomato.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws Exception {
        System.out.println(" =========befre============== ");
        visitTime = new Date();
        executionClass = joinPoint.getTarget().getClass();
        System.out.println("executionClass = " + executionClass.getName());
        //如果是查看日志的controller直接返回
        if (PageController.class == executionClass ) {
            return;
        }
        if (SysUserController.class == executionClass ) {
            return;
        }
        if (SysOperLogController.class == executionClass || MonitorController.class == executionClass) {
            return;
        }

        //获取执行的目标方法名称
        String methodName = joinPoint.getSignature().getName();
        //获取方法的参数列表
        Object[] args = joinPoint.getArgs();

        if (null == args || args.length == 0) {
            executionMethod = executionClass.getMethod(methodName);
            System.out.println("executionMethod = " + executionMethod.getName());
        } else {
            Class[] classes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                Class class1 = args[i].getClass();
                if(class1.equals(ShiroHttpSession.class)) {
                    class1 = HttpSession.class;
                }

                classes[i] =  class1;
                System.out.println("classes[i] = " + classes[i]);

            }
            try {
                executionMethod = executionClass.getMethod(methodName, classes);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 后置处理
     * @After ---->@AfterReturning
     * 解释：执行到核心业务方法或者类时，会先执行AOP。
     * 在aop的逻辑内，先走@Around注解的方法。然后是@Before注解的方法，
     * 然后这两个都通过了，走核心代码，核心代码走完，无论核心有没有返回值，
     * 都会走@After方法。
     * 然后如果程序无异常，
     * 正常返回就走@AfterReturn,
     * 有异常就走@AfterThrowing。
     *
     * @param joinPoint
     */
    @After("execution(* com.zjh.tomato.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint) throws Exception {
        if (SysOperLogController.class == executionClass ) {
            return;
        }
        if (SysUserController.class == executionClass ) {
            return;
        }
        //如果是查看日志的controller直接返回
        if (PageController.class == executionClass) {
            return;
        }
        long executionTime = System.currentTimeMillis() - visitTime.getTime();
        //获取目标类上的注解RequestMapping
        RequestMapping classAnnotation = (RequestMapping) executionClass.getAnnotation(RequestMapping.class);

        //   获取目标方法上的注解
        if (classAnnotation != null && executionMethod !=null) {
            RequestMapping methodAnnotation = (RequestMapping) executionMethod.getAnnotation(RequestMapping.class);
            if (methodAnnotation != null   ) {
                //取到RequestMapping,value的值  可以查看value方法
                String methodUrl = "";
                if(methodAnnotation.value().length>0) {
                    methodUrl = methodAnnotation.value()[0];
                }
                String url = classAnnotation.value()[0] + methodUrl;
                //获取ip地址request.getRemoteAddr();
                String ip = "115.60.94.212";
                SysOperLog sysLog = new SysOperLog();
                sysLog.setTitle(executionClass.getName());
                String requestMethod= "";
                Integer businessType = 0;
                if(executionMethod.getName().startsWith("add")) {
                    businessType=1;
                    requestMethod = "post";
                } else  if(executionMethod.getName().startsWith("update")) {
                    requestMethod = "post";
                    businessType=2;
                } else if(executionMethod.getName().startsWith("remove")) {
                    businessType=3;
                    requestMethod = "get";
                } else if(executionMethod.getName().startsWith("get")) {
                    businessType=4;
                    requestMethod = "get";
                } else {
                    businessType=0;
                    requestMethod = "get";
                }
                sysLog.setBusinessType(businessType);
                sysLog.setMethod(executionMethod.getName());
                sysLog.setRequestMethod(requestMethod);
                sysLog.setOperatorType(0);
                HttpSession session = request.getSession();
sysLog.setOperName(((SysUser)SecurityUtils.getSubject().getPrincipal()).getUsername());
sysLog.setDeptName("null");
sysLog.setOperUrl(url);
sysLog.setOperIp(ip);
sysLog.setOperLocation(LocationUtils.getAddr(ip));
sysLog.setOperParam("null");
sysLog.setJsonResult("null");
sysLog.setStatus(0);
sysLog.setOperTime(visitTime);
              /*  sysLog.setVisitTime(visitTime);
                sysLog.setExecutionTime((int) executionTime);
                sysLog.setIp(ip);
                sysLog.setUrl(url);
                // 获取securityContext上下文
                SecurityContext context = SecurityContextHolder.getContext();
                //次数的User是spring的UserDetail的子类  ,保存了当前登录用户的信息 很多信息
                User principal = (User) context.getAuthentication().getPrincipal();
                //获取username
                String username = principal.getUsername();
                sysLog.setUsername(username);
                //获取方法
                String method = "[类名]" + executionClass.getName() + "[方法名]" + executionMethod.getName();
                sysLog.setMethod(method);*/
                System.out.println(" =========after============== ");
                sysOperLogService.save(sysLog);

            }
        }


    }


}
