package com.example.paymentsysteminjava.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
public class AgentDepositEntity extends BaseEntity {

    @OneToOne
    AgentEntity agentEntity;
    BigDecimal amount = BigDecimal.valueOf(0);
}
