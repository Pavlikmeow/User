package com.shop.user.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewUser {

    private String username;
    private String password;
    private String email;
    private BigDecimal balance;

}
