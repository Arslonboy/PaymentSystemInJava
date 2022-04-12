package com.example.paymentsysteminjava.dto.response.agent.payme;

import com.example.paymentsysteminjava.dto.response.agent.BaseAgentResponse;
import com.example.paymentsysteminjava.entity.AgentEntity;
import com.example.paymentsysteminjava.entity.MerchantEntity;
import com.example.paymentsysteminjava.entity.MerchantServiceEntity;
import com.example.paymentsysteminjava.entity.transaction.TransactionEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class PaynetAgentResponse implements BaseAgentResponse {

    private String response;

    @Override
    public BaseAgentResponse success(
            AgentEntity agent,
            MerchantEntity merchantEntity,
            MerchantServiceEntity merchantServiceEntity,
            TransactionEntity transaction
    ) {

        return new PaynetAgentResponse("success");
    }

    @Override
    public BaseAgentResponse error(AgentEntity agent, MerchantEntity merchantEntity, MerchantServiceEntity merchantServiceEntity, TransactionEntity transaction) {
        return new PaynetAgentResponse("error");
    }
}
