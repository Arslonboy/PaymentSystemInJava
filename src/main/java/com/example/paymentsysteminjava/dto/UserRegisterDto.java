package com.example.paymentsysteminjava.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRegisterDto {

    private String username;
    private String password;
    private String name;
    private String permission;

}
