package com.kafeitoo.blog.service.user.impl;

import com.kafeitoo.blog.model.authentication.OrdinaryUser;
import com.kafeitoo.blog.repository.user.OrdinaryUserRepository;
import com.kafeitoo.blog.service.user.OrdinaryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class OrdinaryUserServiceImpl implements OrdinaryUserService {
    @Autowired
    OrdinaryUserRepository ordinaryUserRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public OrdinaryUser create(OrdinaryUser ordinaryUser) {
        ordinaryUser.setPassword(passwordEncoder.encode(ordinaryUser.getPassword()));
        return ordinaryUserRepository.save(ordinaryUser);
    }
}
