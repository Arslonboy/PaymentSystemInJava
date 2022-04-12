package com.example.paymentsysteminjava.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class MerchantServiceEntity {

    @Id
    private Long id;
    private String name;

    @ManyToOne
    private MerchantEntity merchantEntity;
}
