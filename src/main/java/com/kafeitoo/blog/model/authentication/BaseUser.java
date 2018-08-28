package com.kafeitoo.blog.model.authentication;

import com.kafeitoo.blog.common.AbstractAuditModel;
import com.kafeitoo.blog.enums.UserType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseUser extends AbstractAuditModel {

    @NotBlank
    @Length(max = 50)
    @Column(unique = true,nullable = false,length = 50)
    private String userName;

    @NotBlank
    @Length(max = 50)
    @Column(length = 50)
    private String nickName;

    @Length(max = 20)
    @Column(length = 20)
    private String mobile;

    @Email
    @Length(max = 255)
    @Column
    private String email;

    /**
     * 生效日
     */
    @Temporal(TemporalType.DATE)
    private Date effectiveDate;

    /**
     * 失效日
     */
    @Temporal(TemporalType.DATE)
    private Date expiryDate;

    /**
     * 状态
     */
    private boolean active = true;

    /**
     * 用户类型
     */
    private final UserType type;

    public BaseUser(UserType type) {
        this.type = type;
    }
}
