package com.zjh.tomato.shiro;

import com.zjh.tomato.model.SysMenu;
import com.zjh.tomato.model.SysRole;
import com.zjh.tomato.model.SysUser;
import com.zjh.tomato.service.SysMenuService;
import com.zjh.tomato.service.SysRoleService;
import com.zjh.tomato.service.SysUserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import sun.plugin2.message.GetNameSpaceMessage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 自定义realm
 */


public class UserRealm  extends AuthorizingRealm {
    // sessionDao获取在线用户和同用命登录的
    @Autowired
    private SessionDAO sessionDAO;


    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService roleService;

    @Autowired
    private SysMenuService menuService;

    @Override
    public String getName() {
        return "userRealm";
    }

    @Override

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUser sysUser = (SysUser)principalCollection.getPrimaryPrincipal();

        ArrayList<String> roleList = new ArrayList<String>();
        ArrayList<String> permissionList = new ArrayList<String>();
        List<SysRole> roles = roleService.getSysRolesByUserId(sysUser.getUserId());
        if (CollectionUtils.isNotEmpty(roles)) {
            for (SysRole role : roles) {
                roleList.add(role.getRoleName());
            }
        }
        List<SysMenu> permissions = menuService.getPermissionByUserId(sysUser.getUserId());
        if (CollectionUtils.isNotEmpty(permissions)) {
            for (SysMenu permission : permissions) {
                permissionList.add(permission.getPerms());
                System.out.println("permission.getPerms() = " + permission.getPerms());
            }
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(roleList);
        simpleAuthorizationInfo.addStringPermissions(permissionList);
        return simpleAuthorizationInfo;
    }

    /**
     * 登录认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String username = token.getUsername();
       /* 此段配置获取同用名的用户->*/
        // 获取所有的用户session
        Collection<Session> activeSessions = sessionDAO.getActiveSessions();

        for (Session activeSession : activeSessions) {
            // 有人用同样的用户名进行登录了
            if(username.equals(String.valueOf(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)) ) {
                // session有效期设置为0  立即失效 强制退出
                activeSession.setTimeout(0);
                sessionDAO.delete(activeSession);
                activeSession.stop();
                  break;
            }
        }
        /* <-此段配置获取同用名的用户*/
        SysUser sysUser = sysUserService.getSysUserByUsername(username);
        if (sysUser == null) {
            return null;
        }
        ByteSource credentialsSlat = ByteSource.Util.bytes(sysUser.getSalt());
        return new SimpleAuthenticationInfo(sysUser,sysUser.getPassword(),credentialsSlat,getName());
    }
}
