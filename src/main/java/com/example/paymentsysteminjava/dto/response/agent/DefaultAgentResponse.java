package com.example.paymentsysteminjava.dto.response.agent;

import com.example.paymentsysteminjava.entity.AgentEntity;
import com.example.paymentsysteminjava.entity.MerchantEntity;
import com.example.paymentsysteminjava.entity.MerchantServiceEntity;
import com.example.paymentsysteminjava.entity.transaction.TransactionEntity;


public class DefaultAgentResponse implements BaseAgentResponse {
    @Override
    public BaseAgentResponse success(AgentEntity agent, MerchantEntity merchantEntity, MerchantServiceEntity merchantServiceEntity, TransactionEntity transaction) {
        return null;
    }

    @Override
    public BaseAgentResponse error(AgentEntity agent, MerchantEntity merchantEntity, MerchantServiceEntity merchantServiceEntity, TransactionEntity transaction) {
        return null;
    }
}
