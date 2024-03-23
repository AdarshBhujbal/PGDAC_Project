package com.cdac.oralcaremanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.oralcaremanagement.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
    User findByEmail(String email);

    User findByMobileNo(String mobileNo);
    
}
