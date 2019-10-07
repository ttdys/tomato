package com.zjh.tomato.service;

import com.zjh.tomato.dao.SysMenuMapper;
import com.zjh.tomato.model.SysMenu;
import com.zjh.tomato.model.SysMenuExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuService {

    @Autowired
    private SysMenuMapper menuMapper;

    /**
     * 获取菜单 仅仅该用户可以查看的菜单
     * @param userId
     * @return
     */
    public List<SysMenu> getSysMenusByUserId( Long userId){
        return menuMapper.getSysMenusByUserId(userId);
    }

    /**
     * 查询该用户的权限
     * @param userId
     * @return
     */
    public List<SysMenu> getPermissionByUserId(Long userId) {
        return menuMapper.getPermissionByUserId(userId);
    }

    public List<SysMenu> getAllSysMenu() {
       return menuMapper.selectByExample(new SysMenuExample());
    }

    public void addSysMenu(SysMenu sysMenu) {
        menuMapper.insertSelective(sysMenu);
    }

    public void updateSysMenu(SysMenu sysMenu) {
        menuMapper.updateByPrimaryKeySelective(sysMenu);
    }

    public void removeSysMenu(Long menuId) {
        menuMapper.deleteByPrimaryKey(menuId);
    }
}
