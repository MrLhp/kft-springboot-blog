package com.kafeitoo.blog.service.user.impl;

import com.kafeitoo.blog.bean.UserBean;
import com.kafeitoo.blog.enums.UserType;
import com.kafeitoo.blog.model.authentication.BaseUser;
import com.kafeitoo.blog.model.authentication.OperationUser;
import com.kafeitoo.blog.model.authentication.OrdinaryUser;
import com.kafeitoo.blog.repository.user.BaseUserRepository;
import com.kafeitoo.blog.repository.user.OperationUserRepository;
import com.kafeitoo.blog.repository.user.OrdinaryUserRepository;
import com.kafeitoo.blog.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    BaseUserRepository baseUserRepository;
    @Autowired
    OperationUserRepository operationUserRepository;
    @Autowired
    OrdinaryUserRepository ordinaryUserRepository;

    @Override
    public UserBean findUserByUserName(String username) {
        UserBean user = new UserBean();
        BaseUser baseUser = baseUserRepository.findFirstByUserName(username);
        if (baseUser instanceof OperationUser) {
            user.setPassword(((OperationUser) baseUser).getPassword());
        } else if (baseUser instanceof OrdinaryUser) {
            user.setPassword(((OrdinaryUser) baseUser).getPassword());
        }
        user.setUsername(baseUser.getUserName());
        user.setNickname(baseUser.getNickName());
        return user;
    }
}
