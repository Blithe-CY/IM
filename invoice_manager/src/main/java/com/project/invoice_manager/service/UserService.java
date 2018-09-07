package com.project.invoice_manager.service;

import com.project.invoice_manager.entity.User;

import java.util.List;

public interface UserService  {
    List<User> getUserList();
    User findUserById(String id);
    void save(User user);
    void edit(User user);
    void deleteUserById(String id);
}
