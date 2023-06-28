package com.travelatlasmorocco.repositories;

import com.travelatlasmorocco.entities.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail (String email);
    UserEntity findByUserId(String userId);
}
