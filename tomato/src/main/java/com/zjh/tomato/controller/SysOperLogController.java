package com.zjh.tomato.controller;

import com.github.pagehelper.PageInfo;
import com.zjh.tomato.model.SysOperLog;
import com.zjh.tomato.service.SysOperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author zjh
 */
@Controller
@RequestMapping("monitor/operlog")
public class SysOperLogController {

    @Autowired
    private SysOperLogService sysOperLogService;

    @RequestMapping
    public ModelAndView getAllSysOperLog(ModelAndView mv,
                                         @RequestParam(value = "page",required = false,defaultValue = "1") int page,
                                         @RequestParam(value = "size",required = false,defaultValue = "5") int size) {
        PageInfo<SysOperLog> allSysOperLog = sysOperLogService.getAllSysOperLog(page, size);
        mv.setViewName("monitor/oper-list");
        mv.addObject("pageInfo",allSysOperLog);
        return  mv;
    }


}
