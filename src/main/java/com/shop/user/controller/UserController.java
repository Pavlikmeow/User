package com.shop.user.controller;

import com.shop.user.data.dto.NewUser;
import com.shop.user.data.entity.User;
import com.shop.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public void registerNewUser(@RequestBody NewUser newUser) {
        userService.registerNewUser(newUser);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable UUID id) {
        return userService.getUserById(id);
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable UUID id) {
        userService.deleteUserById(id);
    }

    @DeleteMapping("/{username}")
    public void deleteUserByUsername(@PathVariable String username) {
        userService.deleteUserByUsername(username);
    }

    @PostMapping("/admin/updateBalanceByIdAndBalance/{id}/{balance}")
    public void updateBalanceByIdAndBalance(@PathVariable UUID id, @PathVariable BigDecimal balance) {
        userService.updateBalanceByIdAndBalance(id, balance);
    }

    @PostMapping("/admin/updateBalanceByUsernameAndBalance/{username}/{balance}")
    public void updateBalanceByUsernameAndBalance(@PathVariable String username, @PathVariable BigDecimal balance) {
        userService.updateBalanceByUsernameAndBalance(username, balance);
    }

    @PostMapping("/admin/addBalanceByIdAndAmount/{id}/{amount}")
    public void addBalanceByIdAndAmount(@PathVariable UUID id, @PathVariable BigDecimal amount) {
        userService.addBalanceByIdAndAmount(id, amount);
    }

    @PostMapping("/admin/addBalanceByUsernameAndAmount/{username}/{amount}")
    public void addBalanceByUsernameAndAmount(@PathVariable String username, @PathVariable BigDecimal amount) {
        userService.addBalanceByUsernameAndAmount(username, amount);
    }

    @PostMapping("/admin/freezeById/{id}")
    public void freezeById(@PathVariable UUID id) {
        userService.freezeById(id);
    }

    @PostMapping("/admin/freezeByUsername/{username}")
    public void freezeByUsername(@PathVariable String username) {
        userService.freezeByUsername(username);
    }

    @PostMapping("/admin/unfreezeById/{id}")
    public void unfreezeById(@PathVariable UUID id) {
        userService.unfreezeById(id);
    }

    @PostMapping("/admin/unfreezeByUsername/{username}")
    public void unfreezeByUsername(@PathVariable String username) {
        userService.unfreezeByUsername(username);
    }

    @PostMapping("/purchase/{id}/{value}")
    public void purchase(@PathVariable UUID id, @PathVariable BigDecimal value) {
        userService.purchase(id, value);
    }
}
