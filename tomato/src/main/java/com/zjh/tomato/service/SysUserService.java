package com.zjh.tomato.service;

import com.zjh.tomato.dao.SysUserMapper;
import com.zjh.tomato.model.SysUser;
import com.zjh.tomato.model.SysUserExample;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author zjh
 */
@Service
public class SysUserService {

    @Autowired
    private SysUserMapper mapper;

    public  SysUser getSysUserByUsername(String username)  {
        SysUser user = mapper.getSysUserByUsername(username);
        return user;
    }

    public  void addSysUser(SysUser sysUser) {
        int code = (int)(Math.random()*9000)+1000;
        int i = new Random().nextInt(10000);
        String salt = String.valueOf(code);
        // 加密  存储密文
        SimpleHash simpleHash = new SimpleHash("MD5",sysUser.getPassword(),salt,2);
        sysUser.setPassword(simpleHash.toString());
        sysUser.setSalt(salt);
        sysUser.setOperateTime(new Date());
        sysUser.setOperator("admin");
        sysUser.setMenus(null);
        sysUser.setRoles(null);
        sysUser.setLoginDate(new Date());
        mapper.insertSelective(sysUser);
    }

    public List<SysUser> getAllSysUser() {
        List<SysUser> sysUsers = mapper.selectByExample(new SysUserExample());
        return sysUsers;
    }

    public void removeUser(String userId) {
        Long id =0L ;
        if (StringUtils.isNotEmpty(userId)) {
             id = Long.valueOf(userId);
        }
        mapper.deleteByPrimaryKey(id);
    }

    public SysUser getSysUserByUserId(Long userId) {
        return mapper.selectByPrimaryKey(userId);
    }
}
