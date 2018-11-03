package com.kafeitoo.blog.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@Setter
public class UserBean implements UserDetails {
    private static final long serialVersionUID = -9116309104833714960L;
    private String password;
    private String username;
    private String nickname;
    private Collection<GrantedAuthority> authorities;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;

    public UserBean(String username, String password,
                    Collection<GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public UserBean() {

    }
}
