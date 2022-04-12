package com.example.paymentsysteminjava.dto.crud;

import com.example.paymentsysteminjava.entity.MerchantEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MerchantServiceDto {
    private Long id;
    private String name;
    private Long merchantId;
}
