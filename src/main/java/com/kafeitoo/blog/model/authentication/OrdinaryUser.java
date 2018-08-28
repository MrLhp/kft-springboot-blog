package com.kafeitoo.blog.model.authentication;

import com.kafeitoo.blog.enums.UserType;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

/**
 * 普通用户
 */
public class OrdinaryUser extends BaseUser {
    public OrdinaryUser() {
        super(UserType.ordinary);
    }

    @NotBlank
    @Length(max = 100)
    @Column(length = 100)
    private String password;
}
