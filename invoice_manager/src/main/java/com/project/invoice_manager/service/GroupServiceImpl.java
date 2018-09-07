package com.project.invoice_manager.service;

import com.project.invoice_manager.domain.GroupRepository;
import com.project.invoice_manager.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="GroupService")
public class GroupServiceImpl implements GroupService{

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<Group> getGroupList(){
        return groupRepository.findAll();
    }

    @Override
    public Group findGroupById(String id){
        return groupRepository.findBygroupId(id);
    }

    @Override
    public void deleteGroupById(String id){
        groupRepository.deleteBygroupId(id);
    }

    @Override
    public Group save(Group group){
        return groupRepository.save(group);
    }
}
