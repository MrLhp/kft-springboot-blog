package com.kafeitoo.blog.model.authentication;

import com.kafeitoo.blog.repository.user.BaseUserRepository;
import com.kafeitoo.blog.repository.user.OperationUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 认证和授权
 */
@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    OperationUserRepository operationUserRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        OperationUser operationUser = operationUserRepository.findFirstByUserName(s);
        if (operationUser == null) {
            throw new UsernameNotFoundException("账号不存在");
        }

        this.log.info("【 %s 】【 %s 】", operationUser.getNickName(), operationUser.getUserName());

        return null;
    }
}
