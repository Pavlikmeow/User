package com.shop.user.repository;

import com.shop.user.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findUserById(UUID id);
    User findUserByUsername(String username);
    void deleteUserById(UUID id);
    void deleteUserByUsername(String username);
}
