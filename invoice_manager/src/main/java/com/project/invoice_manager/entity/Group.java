package com.project.invoice_manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="tbl_group")
public class Group {
    @Id
    @Column(name="group_id")
    // 自增
    private String groupId;

    @Column(nullable = false)
    private String group_name;

    @Column(nullable = false)
    private Integer user_number;

}
