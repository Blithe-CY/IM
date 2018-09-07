package com.project.invoice_manager.domain;

import com.project.invoice_manager.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group,String> {

    Group findBygroupId(String id);
    void deleteBygroupId(String id);


}
