package com.kafeitoo.blog.config.security;

import com.kafeitoo.blog.bean.UserBean;
import com.kafeitoo.blog.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * 认证和授权
 */
@Slf4j
@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserBean user = userService.findUserByUserName(s);
        if (user == null) {
            throw new UsernameNotFoundException("账号不存在");
        }
        //todo 添加用户权限

        // return User.withUsername(s).accountExpired(false).accountLocked(false).password(operationUser.getPassword()).roles("USER").build();
        return user;
    }
}
