/*
package com.zjh.tomato.test;

import com.zjh.tomato.model.SysMenu;
import com.zjh.tomato.service.SysMenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration({"classpath:spring/*.xml"})
public class TestMenus {

    @Test
    public void testMs() {
        SysMenuService sysMenuService = new SysMenuService();
        List<SysMenu> menus = sysMenuService.getSysMenusByUserId((long)1);
        ArrayList<SysMenuDto> rootList = new ArrayList<SysMenuDto>();
        for (SysMenu menu : menus) {
            if(menu.getParentId() == 0) {
                SysMenuDto adapter = SysMenuDto.adapter(menu);
                rootList.add(adapter);
            }
        }
        transformerMenu(rootList,menus);

        for (SysMenuDto sysMenuDto : rootList) {
            System.out.println("sysMenuDto.getMenuName() = " + sysMenuDto.getMenuName());
            for (SysMenuDto littleMenu : sysMenuDto.getLittleMenus()) {
                System.out.println("littleMenu.getMenuName() = " + littleMenu.getMenuName());
            }
        }
    }


    private static void transformerMenu(ArrayList<SysMenuDto> rootList, List<SysMenu> menus) {
        for (SysMenuDto sysMenuDto : rootList) {
            Long menuId = sysMenuDto.getMenuId();
            for (SysMenu menu : menus) {
                if(menuId == menu.getParentId()) {
                    SysMenuDto adapter = SysMenuDto.adapter(menu);
                    sysMenuDto.getLittleMenus().add(adapter);
                }
            }
        }
    }
}
*/
