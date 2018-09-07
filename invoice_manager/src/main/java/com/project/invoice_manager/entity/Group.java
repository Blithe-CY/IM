package com.project.invoice_manager.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="tbl_group")
public class Group {
    @Id
    @Column(name="group_id",nullable = false,length = 32)
    @GeneratedValue(generator="system_uuid")
    @GenericGenerator(name="system_uuid",strategy="uuid")
    private String groupId;

    @Column(nullable = false)
    private String group_name;

    @Column(nullable = false)
    private Integer user_number;

    @Column(nullable = false)
    private String group_member;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public Integer getUser_number() {
        return user_number;
    }

    public void setUser_number(Integer user_number) {
        this.user_number = user_number;
    }

    public String getGroup_member() {
        return group_member;
    }

    public void setGroup_member(String group_member) {
        this.group_member = group_member;
    }
}
