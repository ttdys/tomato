package com.zjh.tomato.controller;

import com.zjh.tomato.model.SysRole;
import com.zjh.tomato.service.SysRoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/system/role")
public class SysRoleController {
    @Autowired
    public SysRoleService sysRoleService;

    @RequestMapping
    public ModelAndView getAllRole(ModelAndView mv) {
        List<SysRole> allRole = sysRoleService.getAllRole();
        mv.setViewName( "system/role/list");
        mv.addObject("roles",allRole);
        return mv;
    }

    @RequestMapping("/add")
    @RequiresPermissions("system:role:add")
    public String addRole(SysRole sysRole,Model model) {
        sysRoleService.addRole(sysRole);
        model.addAttribute("system/role/list");
        return null;
    }
    @RequestMapping("/update")
    @RequiresPermissions("system:role:edit")
    public String updateRole(SysRole sysRole) {
        sysRoleService.updateRole(sysRole);
        return "redirect:system/role.do";
    }
    @RequestMapping("/remove/{roleId}")
    @RequiresPermissions("system:role:remove")
    public String removeRole(@PathVariable Long roleId) {
        sysRoleService.removeRole(roleId);
        return "redirect:system/role.do";
    }
}
