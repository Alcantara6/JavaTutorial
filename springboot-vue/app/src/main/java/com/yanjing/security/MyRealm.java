package com.yanjing.security;

import com.yanjing.entity.User;
import com.yanjing.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yanjing
 * @date 2022/6/12
 */
public class MyRealm extends AuthorizingRealm {


    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return new SimpleAuthorizationInfo();
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        // 获取用户输入的账户
        String username = (String) authenticationToken.getPrincipal();
        // 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        User user = userService.getByName(username);
        if (null == user) {
            return null;
        }

        return new SimpleAuthenticationInfo(
                username, // 用户
                user.getPassword(), // 密码
                ByteSource.Util.bytes(user.getSalt()), // salt=username+salt
                getName() // realm name
        );
    }
}
