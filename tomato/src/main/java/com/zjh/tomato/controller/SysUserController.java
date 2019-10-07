package com.zjh.tomato.controller;

import com.zjh.tomato.model.SysMenu;
import com.zjh.tomato.model.SysUser;
import com.zjh.tomato.service.SysMenuService;
import com.zjh.tomato.service.SysOperLogService;
import com.zjh.tomato.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zjh
 */
@Slf4j
@Controller
@RequestMapping("/system/user")
public class SysUserController {

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysOperLogService sysOperLogService;

    @RequestMapping(value = "/loginUser")
    public String loginUser(
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "verificationCode", required = true) String verificationCode,
            @RequestParam(value = "rememberMe", required = false) boolean rememberMe,
            HttpSession session, HttpServletRequest request) {
        String verifyCode = (String) session.getAttribute("verifyCode");
        if (!StringUtils.equalsIgnoreCase(verificationCode, verifyCode)) {
            return "login";
        }

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            sysOperLogService.addSysLoginLog(request,username);
            SysUser user = (SysUser) subject.getPrincipal();
            List<SysMenu> menus = sysMenuService.getSysMenusByUserId(user.getUserId());
            session.setAttribute("menus",menus);
           session.setAttribute("user", user);
            return "/index";
        } catch (UnauthenticatedException e) {
            e.printStackTrace();
           log.error("{} occur error things{}", this.getClass().getName(), e.getMessage());
            return "login";
        }
    }

    @RequestMapping
    @RequiresPermissions("system:user:view")
    public ModelAndView userManager(ModelAndView modelAndView) {
        List<SysUser> users = sysUserService.getAllSysUser();
        modelAndView.addObject("users",users);
        modelAndView.setViewName("system/user/list");
        return modelAndView;
    }
    @RequestMapping("/add")
    @RequiresPermissions("system:user:add")
    public String addUser(SysUser sysUser) {
        sysUserService.addSysUser(sysUser);
        return "redirect:/system/user.do";
    }
    @RequestMapping("/remove/{userId}")
    @RequiresPermissions("system:user:remove")
    public String removeUser(@PathVariable String userId) {
        sysUserService.removeUser(userId);
        return "redirect:/system/user.do";
    }

    @RequestMapping("/privatePage")
    public  String privatePage(@RequestParam("userId") Long userId,Model model) {
        SysUser sysUserByUserId = sysUserService.getSysUserByUserId(userId);
        model.addAttribute("sysUser",sysUserByUserId);
        return "system/user/privatePage";
    }

}
