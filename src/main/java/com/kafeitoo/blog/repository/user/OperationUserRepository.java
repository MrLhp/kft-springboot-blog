package com.kafeitoo.blog.repository.user;

import com.kafeitoo.blog.model.authentication.OperationUser;
import org.springframework.data.repository.Repository;

public interface OperationUserRepository extends Repository<OperationUser,Long> {
    OperationUser save(OperationUser user);

    OperationUser findFirstByUserName(String username);
}
