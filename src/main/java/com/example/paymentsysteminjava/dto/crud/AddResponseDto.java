package com.example.paymentsysteminjava.dto.crud;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddResponseDto {
    private int status;
    private String message;
}
