package com.kafeitoo.blog.model.authentication;

import com.kafeitoo.blog.enums.UserType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotBlank;

/**
 * 平台运营用户
 */
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class OperationUser extends BaseUser {

    public OperationUser() {
        super(UserType.administrator);
    }

    @NotBlank
    @Length(max = 100)
    @Column(length = 100)
    private String password;

}
