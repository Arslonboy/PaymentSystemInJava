package com.example.paymentsysteminjava.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
public class MerchantDepositEntity extends BaseEntity{
    @OneToOne
    MerchantEntity merchantEntity;
    BigDecimal amount = BigDecimal.valueOf(0);
}
