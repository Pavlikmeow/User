package com.shop.user.service;

import com.shop.user.data.entity.User;
import com.shop.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OperationService {

    private final UserRepository userRepository;

    @Transactional
    public void purchase(UUID id, BigDecimal value) {
        User user = userRepository.findUserById(id);
        if (user.getBalance().compareTo(value) >= 0) {
            BigDecimal newBalance = user.getBalance().subtract(value);
            user.setBalance(newBalance);
        } else {
            throw new RuntimeException(String.format("User with id: {%s} dont have enough balance", id));
        }
    }

    @Transactional
    public void refund(UUID id, BigDecimal value) {
        User user = userRepository.findUserById(id);
        user.setBalance(user.getBalance().add(value));
    }

}
