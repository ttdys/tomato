package com.zjh.tomato.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zjh.tomato.exception.CommonException;
import com.zjh.tomato.model.SysMenu;
import com.zjh.tomato.model.dto.SysMenuDto;
import com.zjh.tomato.service.SysMenuService;
import com.zjh.tomato.utils.MenuJson;
import com.zjh.tomato.utils.PageInfoHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zjh
 */
@Slf4j
@Controller
@RequestMapping("/system/menu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;


    @RequestMapping
    public ModelAndView getAllSysMenu (ModelAndView mv) {
     /*  List<SysMenu> menusMax = sysMenuService.getAllSysMenu();*/
        mv.setViewName("system/menu/list");
      /*  mv.addObject("menusMax",menusMax);*/
        return mv;
    }
    @RequestMapping(value = "/menuJson",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String getAllSysMenu() {

        List<SysMenu> menus = sysMenuService.getAllSysMenu();
       List<MenuJson> jsons= initMenuJson(menus);

        int size = menus.size();
        PageInfoHolder<MenuJson> infoHolder = new PageInfoHolder<MenuJson>();
        infoHolder.setDraw(0);
        infoHolder.setRecordsFiltered(Long.valueOf(size));
        infoHolder.setRecordsTotal(Long.valueOf(size));
        infoHolder.setStart(0);
        infoHolder.setLength(size);
        infoHolder.setData(jsons);
        String jsonString = JSONObject.toJSONString(infoHolder);

        return  jsonString;
    }

    private List<MenuJson> initMenuJson(List<SysMenu> menus) {
        ArrayList<MenuJson> rootList = new ArrayList<MenuJson>();
        for (SysMenu menu : menus) {
            if (menu.getParentId() == 0 ) {
                MenuJson menuJson = new MenuJson();
                menuJson.setMenuId(menu.getMenuId());
                menuJson.setMenuName(menu.getMenuName());
                menuJson.setMenuType(menu.getMenuType());
                menuJson.setMenuSort(menu.getMenuSort());
                menuJson.setPerms(menu.getPerms());
                menuJson.setRemark(menu.getRemark());
                menuJson.setUrl(menu.getUrl());
                menuJson.setParentId(menu.getParentId());
               rootList.add(menuJson);
            }
        }
        children(rootList,menus);
        return rootList;
    }

    private void children(ArrayList<MenuJson> rootList, List<SysMenu> menus) {
        for (MenuJson menuJson : rootList) {
            Long menuId = menuJson.getMenuId();
            for (SysMenu menu : menus) {
                if(menu.getParentId().equals(menuId)) {
                    MenuJson menuJson1 = new MenuJson();
                    menuJson1.setMenuId(menu.getMenuId());
                    menuJson1.setMenuName(menu.getMenuName());
                    menuJson1.setMenuType(menu.getMenuType());
                    menuJson1.setMenuSort(menu.getMenuSort());
                    menuJson1.setPerms(menu.getPerms());
                    menuJson1.setRemark(menu.getRemark());
                    menuJson1.setUrl(menu.getUrl());
                    menuJson1.setParentId(menu.getParentId());
                    menuJson.getChildren().add(menuJson1);
                }
            }
            children((ArrayList<MenuJson>) menuJson.getChildren(),menus);
        }
    }



   /* @RequestMapping("/page")
    @ResponseBody
    public String getAllSysMenuPage () {
        List<SysMenu> menus = sysMenuService.getAllSysMenu();
        ArrayList<SysMenuDto> sysMenuDtos = new ArrayList<SysMenuDto>();
        for (SysMenu sysMenu : menus) {
            SysMenuDto sysMenuDto = new SysMenuDto();
            sysMenuDto.setName(sysMenu.getMenuName());
            sysMenuDto.setStatus(1);
            sysMenuDto.setPermissionValue(sysMenu.getPerms());
            sysMenuDto.setPid(sysMenu.getParentId().intValue());
            sysMenuDtos.add(sysMenuDto);
        }

        String strs = JSONArray.toJSONString(sysMenuDtos);

        return strs;
    }*/








    @RequestMapping("/add")
    public String  addSysMenu(SysMenu sysMenu) {
        sysMenuService.addSysMenu(sysMenu);
        return "system/menu/list";
    }
    @RequestMapping("/update")
    public String updateSysMenu (SysMenu sysMenu) {
        sysMenuService.updateSysMenu(sysMenu);
        return "system/menu/list";
    }
    @RequestMapping("/remove/{menuId}")
    public String  removeSysMenu(@PathVariable Long menuId) {
        sysMenuService.removeSysMenu(menuId);
        return "system/menu/list";
    }
}
