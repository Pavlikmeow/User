package com.shop.user.service;

import com.shop.user.data.entity.Notification;
import com.shop.user.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void createNewNotification(Notification notification) {
        notificationRepository.save(notification);
    }

    public List<Notification> findAllByUserId(UUID id) {
        return notificationRepository.findAllByUserId(id);
    }

    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }

    public void deleteById(UUID id) {
        notificationRepository.deleteById(id);
    }

}
