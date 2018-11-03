package com.kafeitoo.blog.repository.user;

import com.kafeitoo.blog.model.authentication.OrdinaryUser;
import org.springframework.data.repository.Repository;

public interface OrdinaryUserRepository extends Repository<OrdinaryUser,Long> {
    OrdinaryUser findFirstByUserName(String username);

    OrdinaryUser save(OrdinaryUser ordinaryUser);
}
