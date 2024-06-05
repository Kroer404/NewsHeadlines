package com.waylau.springboot.newsserver.repository;

import com.waylau.springboot.newsserver.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User,Long>{
    User findByUsername(String username);
}
