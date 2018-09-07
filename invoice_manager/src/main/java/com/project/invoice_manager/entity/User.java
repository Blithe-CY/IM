package com.project.invoice_manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_user")
public class User  {

    @Id
    @Column(name = "user_id",nullable = false)
    private String userId;

    @Column(name = "user_name",nullable = false)
    private String user_name;

    @Column(name = "user_password",nullable = false)
    private String user_password;

    @Column(name = "user_gender")
    private String user_gender;

    @Column(name = "user_phone")
    private String user_phone;

    @Column(name = "user_qq")
    private String user_qq;

    @Column(name = "user_account", nullable = false)
    private String user_account;

    @Column(name = "user_type", nullable = false)
    private Integer user_type;

    @Column(name = "user_mail")
    private String user_mail;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(String user_gender) {
        this.user_gender = user_gender;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_qq() {
        return user_qq;
    }

    public void setUser_qq(String user_qq) {
        this.user_qq = user_qq;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public Integer getUser_type() {
        return user_type;
    }

    public void setUser_type(Integer user_type) {
        this.user_type = user_type;
    }

    public String getUser_mail() {
        return user_mail;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public String toString(){
        return "id:" + this.getUserId() + " name:" + this.getUser_name();
    }
}