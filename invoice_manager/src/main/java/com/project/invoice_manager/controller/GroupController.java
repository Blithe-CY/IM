package com.project.invoice_manager.controller;

import com.project.invoice_manager.domain.UserRepository;
import com.project.invoice_manager.entity.Group;
import com.project.invoice_manager.entity.User;
import com.project.invoice_manager.model.Response;
import com.project.invoice_manager.service.GroupService;
import com.project.invoice_manager.service.ResponseFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.regex.Pattern;

// 支持跨域
@CrossOrigin
@RestController
@RequestMapping(value="/group")
public class GroupController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private GroupService groupService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/upload")
    public Response groupUpload(@RequestBody Map<String,Object> info) {
        try{
            String group_name = (String) info.get("group_name");
            String user_id = (String) info.get("user_id");
            System.out.println(group_name);

            Group group = new Group();
            group.setUser_number(0);
            group.setGroup_name(group_name);
            group.setGroup_member(user_id+":100;");
            group = groupService.save(group);

            // 返回了生成的group_id
            return ResponseFactory.SuccessResponse(group.getGroupId());
        }
        catch (Exception e){
            logger.info(e.toString());
            return ResponseFactory.FailResponse(null);
        }
    }

    @PostMapping(value="/addMember") //String group_id,String user_id
    public Response groupAddMember(@RequestBody Map<String,Object> info){
        try{
            String group_id = (String) info.get("group_id");
            String user_id = (String) info.get("user_id");

            Group group = groupService.findGroupById(group_id);

            Integer user_number = group.getUser_number() + 1;
            group.setUser_number(user_number);

            String group_member= group.getGroup_member();
            String pattern = ".*"+ user_id +".*";
            boolean isMatch = Pattern.matches(pattern, group_member);
            if(isMatch){
                return ResponseFactory.FailResponse("该用户已经加入团队");
            }
            // 此处未修改比例
            group_member += user_id + ":" + "?" +";";
            group.setGroup_member(group_member);

            groupService.save(group);

            User user = userRepository.findByUserId(user_id);
            return ResponseFactory.SuccessResponse(user);
        }
        catch (Exception e){
            logger.info(e.toString());
            return ResponseFactory.FailResponse(null);
        }
    }
}
