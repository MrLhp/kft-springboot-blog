package com.kafeitoo.blog.service.user;

import com.kafeitoo.blog.bean.UserBean;

public interface UserService {
    UserBean findUserByUserName(String username);
}
