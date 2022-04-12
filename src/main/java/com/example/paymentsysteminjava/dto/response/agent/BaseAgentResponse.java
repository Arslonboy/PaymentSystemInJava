package com.example.paymentsysteminjava.dto.response.agent;

import com.example.paymentsysteminjava.entity.AgentEntity;
import com.example.paymentsysteminjava.entity.MerchantEntity;
import com.example.paymentsysteminjava.entity.MerchantServiceEntity;
import com.example.paymentsysteminjava.entity.transaction.TransactionEntity;
import com.example.paymentsysteminjava.entity.transaction.TransactionState;

public interface BaseAgentResponse {
    default BaseAgentResponse response(
            AgentEntity agent,
            MerchantEntity merchantEntity,
            MerchantServiceEntity merchantServiceEntity,
            TransactionEntity transaction
    ) {
        if (transaction.getTransactionState() == TransactionState.CHECKED.getState()) {
            return success(agent, merchantEntity, merchantServiceEntity, transaction);
        } else {
            return error(agent, merchantEntity, merchantServiceEntity, transaction);
        }
    }

    BaseAgentResponse success(AgentEntity agent,
                              MerchantEntity merchantEntity,
                              MerchantServiceEntity merchantServiceEntity,
                              TransactionEntity transaction);

    BaseAgentResponse error(AgentEntity agent,
                            MerchantEntity merchantEntity,
                            MerchantServiceEntity merchantServiceEntity,
                            TransactionEntity transaction);
}
