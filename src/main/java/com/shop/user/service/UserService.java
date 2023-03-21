package com.shop.user.service;

import com.shop.user.data.dto.NewUser;
import com.shop.user.data.entity.User;
import com.shop.user.data.mapper.NewUserMapper;
import com.shop.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final NewUserMapper newUserMapper;

    public void registerNewUser(NewUser newUser) {
        User user = newUserMapper.mapToUser(newUser);
        userRepository.save(user);
    }

    public User getUserById(UUID id) {
        return userRepository.findUserById(id);
    }

    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public void deleteUserById(UUID id) {
        userRepository.deleteUserById(id);
    }

    public void deleteUserByUsername(String username) {
        userRepository.deleteUserByUsername(username);
    }

    @Transactional
    public void updateBalanceByIdAndBalance(UUID id, int balance) {
        User user = userRepository.findUserById(id);
        user.setBalance(balance);
    }

    @Transactional
    public void updateBalanceByUsernameAndBalance(String username, int balance) {
        User user = userRepository.findUserByUsername(username);
        user.setBalance(balance);
    }

    @Transactional
    public void addBalanceByIdAndAmount(UUID id, int amount) {
        User user = userRepository.findUserById(id);
        user.setBalance(user.getBalance() + amount);
    }

    @Transactional
    public void addBalanceByUsernameAndAmount(String username, int amount) {
        User user = userRepository.findUserByUsername(username);
        user.setBalance(user.getBalance() + amount);
    }

    @Transactional
    public void freezeById(UUID id) {
        User user = userRepository.findUserById(id);
        user.setFrozen(true);
    }

    @Transactional
    public void freezeByUsername(String username) {
        User user = userRepository.findUserByUsername(username);
        user.setFrozen(true);
    }

    @Transactional
    public void unfreezeById(UUID id) {
        User user = userRepository.findUserById(id);
        user.setFrozen(false);
    }

    @Transactional
    public void unfreezeByUsername(String username) {
        User user = userRepository.findUserByUsername(username);
        user.setFrozen(false);
    }
}
