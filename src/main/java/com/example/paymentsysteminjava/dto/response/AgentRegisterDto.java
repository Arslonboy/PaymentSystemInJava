package com.example.paymentsysteminjava.dto.response;

import com.example.paymentsysteminjava.dto.UserRegisterDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgentRegisterDto extends UserRegisterDto {
    private Double commissionFee;
}
