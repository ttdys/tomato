package com.zjh.tomato.controller;

import com.github.pagehelper.PageInfo;
import com.zjh.tomato.model.SysLoginLog;
import com.zjh.tomato.model.SysOnline;
import com.zjh.tomato.model.SysUser;
import com.zjh.tomato.service.SysOperLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author zjh
 */
@Slf4j
@Controller
@RequestMapping("monitor")
public class MonitorController {

    @Autowired
    private SessionDAO sessionDAO;

    @Autowired
    private SysOperLogService sysOperLogService;

    @RequestMapping("/online")
    public ModelAndView online() {
        Collection<Session> activeSessions = sessionDAO.getActiveSessions();
        List<SysOnline>  onlineList = new ArrayList<>();
        for (Session activeSession : activeSessions) {
            if (activeSession != null && sessionDAO.readSession(activeSession.getId()) != null) {
                SysOnline sysOnline = new SysOnline();
                SysUser user =(SysUser) SecurityUtils.getSubject().getPrincipal();
                sysOnline.setUsername(user.getUsername());
                //todo 为了演示 ip定位115.60.93.31 =activeSession.getHost()
                String ip = "115.60.93.31";
                sysOnline.setIp(ip);
                sysOnline.setLastAccessTime(activeSession.getLastAccessTime());
                // todo 为了演示LocationUtils.getAddr(ip)
                sysOnline.setAddr("郑州");
                if(activeSession.getId().equals(SecurityUtils.getSubject().getSession().getId())) {
                    sysOnline.setSessionId(null);
                } else {
                    sysOnline.setSessionId((String) activeSession.getId());
                }


                onlineList.add(sysOnline);
            }
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("onlineList",onlineList);
        mv.setViewName("monitor/online-list");
        return mv;
    }

    @RequestMapping("/forceLogout/{sessionId}")
    public String forceLogout(@PathVariable("sessionId") String sessionId) {
        Session session = sessionDAO.readSession(sessionId);
        session.setTimeout(0);
        session.stop();
        sessionDAO.delete(session);
        return "redirect:/monitor/online.do";
    }

    @RequestMapping("/logininfor")
    public ModelAndView loginInfo(@RequestParam(value = "page",required = false,defaultValue = "1")Integer page,
                                  @RequestParam(value = "size",required = false,defaultValue = "5")Integer size,
                                  ModelAndView modelAndView){
        PageInfo<SysLoginLog> pageInfo = sysOperLogService.getAllSysLoginLog(page, size);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("monitor/login-log-list");
        return modelAndView;
    }


    @RequestMapping("/data")
    public String index() {
        return "redirect:/druid/index.html";
    }

}
