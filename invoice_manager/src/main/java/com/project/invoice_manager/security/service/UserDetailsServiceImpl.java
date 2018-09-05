package com.project.invoice_manager.security.service;

import com.project.invoice_manager.domain.UserRepository;
import com.project.invoice_manager.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.project.invoice_manager.security.model.MyUserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//@Component
@Service("UserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        logger.info("用户的账号：{}",id);

//        System.out.println(userRepository);
        User user = userRepository.findByUserId(id);

//        User user = null;
//        System.out.println("获取到了！");
        logger.info("[!]" + user.toString());

        if(user == null){
            throw new UsernameNotFoundException("不存在该用户！");
        }


        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        if(user.getUser_type() == 0){
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        }
        MyUserDetails myUserDetails = new MyUserDetails(user);
        myUserDetails.setAuthorities(authorities);

        return myUserDetails;
    }
}
