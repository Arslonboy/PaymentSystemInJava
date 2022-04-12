package com.example.paymentsysteminjava.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
@Getter
@Setter
public class AgentServiceEntity extends BaseEntity{

   private long agentEntityId;
   private double commissionFee;
   @Column(unique = true)
   private long serviceId;

}
