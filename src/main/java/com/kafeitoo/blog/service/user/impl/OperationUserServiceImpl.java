package com.kafeitoo.blog.service.user.impl;

import com.kafeitoo.blog.model.authentication.OperationUser;
import com.kafeitoo.blog.repository.user.OperationUserRepository;
import com.kafeitoo.blog.service.user.OperationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OperationUserServiceImpl implements OperationUserService {
    @Autowired
    OperationUserRepository operationUserRepository;

    @Override
    public OperationUser create(OperationUser user) {
        //todo:感觉有待改进
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return operationUserRepository.save(user);
    }
}
