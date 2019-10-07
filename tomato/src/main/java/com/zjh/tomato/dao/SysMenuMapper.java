package com.zjh.tomato.dao;

import com.zjh.tomato.model.SysMenu;
import com.zjh.tomato.model.SysMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zjh
 */
public interface SysMenuMapper {
    int countByExample(SysMenuExample example);

    int deleteByExample(SysMenuExample example);

    int deleteByPrimaryKey(Long menuId);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    List<SysMenu> selectByExample(SysMenuExample example);

    SysMenu selectByPrimaryKey(Long menuId);

    int updateByExampleSelective(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    int updateByExample(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    List<SysMenu> getSysMenusByUserId(@Param("userId") Long userId);

    List<SysMenu> getPermissionByUserId(@Param("userId") Long userId);
}