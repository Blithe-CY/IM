package com.project.invoice_manager.domain;

import com.project.invoice_manager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findByUserId(String id);
    void deleteByUserId(String id);
}
