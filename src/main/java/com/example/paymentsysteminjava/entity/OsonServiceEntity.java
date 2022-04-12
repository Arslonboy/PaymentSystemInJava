package com.example.paymentsysteminjava.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class OsonServiceEntity extends BaseEntity{
    @OneToOne
    private MerchantServiceEntity merchantServiceEntity;
}
