package com.kafeitoo.blog.repository.user;

import com.kafeitoo.blog.model.authentication.BaseUser;
import org.springframework.data.repository.Repository;

public interface BaseUserRepository extends Repository<BaseUser,Long> {
    BaseUser findFirstByUserName(String username);
}
