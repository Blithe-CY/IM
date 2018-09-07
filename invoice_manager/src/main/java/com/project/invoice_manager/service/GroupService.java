package com.project.invoice_manager.service;


import com.project.invoice_manager.entity.Group;

import java.util.List;

public interface GroupService {
    List<Group> getGroupList();
    Group findGroupById(String id);
    void deleteGroupById(String id);
    Group save(Group group);

}
