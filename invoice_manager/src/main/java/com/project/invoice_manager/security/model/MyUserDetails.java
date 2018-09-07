package com.project.invoice_manager.security.model;

import com.project.invoice_manager.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import java.util.Collection;
import java.util.List;


public class MyUserDetails implements UserDetails {
    private User user;

    private Boolean enabled;
    private List<? extends GrantedAuthority> authorities;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean credentialsNonExpired;

    public MyUserDetails (User user){
        this.user = user;
        this.enabled = true;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<? extends GrantedAuthority> auth){
        this.authorities = authorities;
    }

    @Override
    public boolean isAccountNonExpired(){
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked(){
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled(){
        return enabled;
    }

    @Override
    public String getUsername(){
        return user.getUser_name();
    }

    @Override
    public String getPassword(){
        return user.getUser_password();
    }

}
