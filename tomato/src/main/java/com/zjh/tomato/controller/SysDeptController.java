package com.zjh.tomato.controller;

import com.zjh.tomato.exception.CommonException;
import com.zjh.tomato.model.SysDept;
import com.zjh.tomato.service.SysDeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("system/dept")
public class SysDeptController {
    @Autowired
    private SysDeptService sysDeptService;

    @RequestMapping
    public ModelAndView getAllDept(ModelAndView mv) {
        List<SysDept> allDept = sysDeptService.getAllDept();
        mv.setViewName("system/dept/list");
        mv.addObject("allDept", allDept);
        return mv;
    }
    @RequestMapping("add")
    public ModelAndView  addDept(SysDept dept) {
        sysDeptService.addDept(dept);
        return null;
    }
    @RequestMapping("update")
    public ModelAndView  updateDept(SysDept dept) {
        sysDeptService.updateDept(dept);
        return null;
    }
    @RequestMapping("remove/{deptId}")
    public String  removeDept(@PathVariable("deptId")String deptId) {
        if (StringUtils.isEmpty(deptId)) {
            log.error("id error");
            throw  new CommonException("id error");
        }
        sysDeptService.removeDept(Long.valueOf(deptId));
        return  "";
    }
}
