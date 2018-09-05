package com.project.invoice_manager.service;

import com.project.invoice_manager.domain.UserRepository;
import com.project.invoice_manager.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(String id){
        return userRepository.findByUserId(id);
    }

    @Override
    public void save(User user){
        userRepository.save(user);
    }

    @Override
    public void edit(User user){
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(String id){
        userRepository.deleteByUserId(id);
    }


}
