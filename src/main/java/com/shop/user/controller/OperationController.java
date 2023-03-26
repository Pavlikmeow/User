package com.shop.user.controller;

import com.shop.user.service.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class OperationController {

    private final OperationService operationService;

    @PostMapping("/purchase/{id}/{value}")
    public void purchase(@PathVariable UUID id, @PathVariable BigDecimal value) {
        operationService.purchase(id, value);
    }

    @PostMapping("/refund/{id}/{value}")
    public void refund(@PathVariable UUID id, @PathVariable BigDecimal value) {
        operationService.refund(id, value);
    }

}
