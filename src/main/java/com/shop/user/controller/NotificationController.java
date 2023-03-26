package com.shop.user.controller;

import com.shop.user.data.entity.Notification;
import com.shop.user.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public void createNewNotification(@RequestBody Notification notification) {
        notificationService.createNewNotification(notification);
    }

    @GetMapping("/{id}")
    public List<Notification> getAllByUserId(@PathVariable UUID id) {
        return notificationService.findAllByUserId(id);
    }

    @GetMapping
    public List<Notification> getAll() {
        return notificationService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        notificationService.deleteById(id);
    }

}
