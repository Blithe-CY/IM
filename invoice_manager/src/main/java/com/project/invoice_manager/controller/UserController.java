package com.project.invoice_manager.controller;

import com.project.invoice_manager.entity.User;
import com.project.invoice_manager.model.Response;
import com.project.invoice_manager.service.ResponseFactory;
import com.project.invoice_manager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private UserService userService;
    // 支持跨域
    @CrossOrigin
    @PostMapping("/alterInfo")
    public Response alterInfo(User user,String user_id){
        try{
            // JPA自身的save无法局部更新
            // 暂时先用这种方法
            User res = userService.findUserById(user_id);
            if(user.getUser_name().equals(""))
                res.setUser_name(user.getUser_name());
            if(user.getUser_mail().equals(""))
                res.setUser_mail(user.getUser_mail());
            if(user.getUser_phone().equals(""))
                res.setUser_phone(user.getUser_phone());
            if(user.getUser_gender().equals(""))
                res.setUser_gender(user.getUser_gender());
            if(user.getUser_account().equals(""))
                res.setUser_account(user.getUser_account());

            userService.save(res);
            return ResponseFactory.SuccessResponse(null);
        }
        catch (Exception e){
            logger.info(e.toString());
            return ResponseFactory.FailResponse(null);
        }
    }



}
