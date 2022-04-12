package com.example.paymentsysteminjava.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@Getter
@Setter
public class MerchantEntity extends UserEntity{

    private String secretKey;



    @Transient
    private Boolean isUcell  = true;
    @Transient
    private Boolean isYandex = false;
    @Transient
    private Boolean isPayme  = true;
}
