package com.project.invoice_manager.controller;

import com.project.invoice_manager.entity.User;
import com.project.invoice_manager.model.Response;
import com.project.invoice_manager.service.ResponseFactory;
import com.project.invoice_manager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.Map;

// 支持跨域
@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @PostMapping("/alterInfo")
    public Response alterInfo(@RequestBody Map<String, String> user){
        try{
            // JPA自身的save无法局部更新
            // 暂时先用这种方法
            System.out.println(user.toString());
            System.out.println("userId:"+user.get("user_id"));
            User res = userService.findUserById(user.get("user_id"));
            System.out.print("用户：");
            System.out.println(res);
            if(!user.get("user_name").equals(""))
                res.setUser_name(user.get("user_name"));
            System.out.println("getname");
            if(!user.get("user_mail").equals(""))
                res.setUser_mail(user.get("user_mail"));
            System.out.println("getmail");
            if(!user.get("user_phone").equals(""))
                res.setUser_phone(user.get("user_phone"));
            System.out.println("getphone");
            if(!user.get("user_gender").equals(""))
                res.setUser_gender(user.get("user_gender"));
            System.out.println("getgender");
            if(!user.get("user_qq").equals(""))
                res.setUser_qq(user.get("user_qq"));
            System.out.println("getqq");
            System.out.println(userService);

            System.out.println(res);
            userService.save(res);
            return ResponseFactory.SuccessResponse(null);
        }
        catch (Exception e){
            logger.info(e.toString());
            return ResponseFactory.FailResponse(null);
        }
    }



}
