package com.example.paymentsysteminjava.entity.transaction;

import com.example.paymentsysteminjava.entity.AgentEntity;
import com.example.paymentsysteminjava.entity.BaseEntity;
import com.example.paymentsysteminjava.entity.MerchantEntity;
import com.example.paymentsysteminjava.entity.OsonServiceEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class TransactionEntity extends BaseEntity {
    private int transactionState;
    private BigDecimal transactionAmountFromAgent;
    private BigDecimal transactionAmountToMerchant;
    private String transactionAccount;

    @ManyToOne
    private AgentEntity agent;

    @ManyToOne
    private MerchantEntity merchant;

    @ManyToOne
    private OsonServiceEntity osonServiceEntity;

}
