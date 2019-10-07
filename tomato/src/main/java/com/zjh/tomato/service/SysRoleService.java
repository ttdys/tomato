package com.zjh.tomato.service;

import com.zjh.tomato.dao.SysRoleMapper;
import com.zjh.tomato.model.SysRole;
import com.zjh.tomato.model.SysRoleExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SysRoleService {

    @Autowired
    private SysRoleMapper roleMapper;

    public List<SysRole> getSysRolesByUserId(Long userId){
        return roleMapper.getSysRolesByUserId(userId);
    }

    public List<SysRole> getAllRole() {
        SysRoleExample example = new SysRoleExample();
        return roleMapper.selectByExample(example);
    }


    public void addRole(SysRole sysRole) {
        sysRole.setOperateTime(new Date());
        sysRole.setOperator("admin");
        int i = roleMapper.insertSelective(sysRole);
        sysRole.setRoleSort(i);
        roleMapper.updateByPrimaryKeySelective(sysRole);
    }

    public void updateRole(SysRole sysRole) {
        roleMapper.updateByPrimaryKeySelective(sysRole);
    }

    public void removeRole(Long roleId) {
      roleMapper.deleteByPrimaryKey(roleId);
    }
}
