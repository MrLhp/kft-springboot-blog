package com.kafeitoo.blog.service.user.impl;

import com.kafeitoo.blog.model.authentication.OperationUser;
import com.kafeitoo.blog.repository.user.OperationUserRepository;
import com.kafeitoo.blog.service.user.OperationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OperationUserServiceImpl implements OperationUserService {
    @Autowired
    OperationUserRepository operationUserRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public OperationUser create(OperationUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return operationUserRepository.save(user);
    }
}
