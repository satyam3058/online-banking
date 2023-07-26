package com.onlinebanking.springrest.repository;

import com.onlinebanking.springrest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByUserId(long userId);
}