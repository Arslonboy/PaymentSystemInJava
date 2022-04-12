package com.example.paymentsysteminjava.service.transaction;

import com.example.paymentsysteminjava.dto.request.agent.DefaultAgentRequest;
import com.example.paymentsysteminjava.dto.response.agent.BaseAgentResponse;
import com.example.paymentsysteminjava.dto.response.agent.BaseCheckResponse;
import com.example.paymentsysteminjava.entity.*;
import com.example.paymentsysteminjava.entity.transaction.TransactionEntity;
import com.example.paymentsysteminjava.entity.transaction.TransactionState;
import com.example.paymentsysteminjava.repository.AgentServiceRepository;
import com.example.paymentsysteminjava.repository.MerchantRepository;
import com.example.paymentsysteminjava.repository.OsonRepository;
import com.example.paymentsysteminjava.repository.TransactionRepository;
import com.example.paymentsysteminjava.service.gateway.PaymeTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CheckTransactionService {
    private final OsonRepository osonRepository;
    private final MerchantRepository merchantRepository;
    private final PaymeTransactionService paymeTransactionService;
    private final TransactionRepository transactionRepository;
    private final AgentServiceRepository agentServiceRepository;


    public BaseAgentResponse check(DefaultAgentRequest defaultAgentRequest,
                                   AgentEntity agentEntity) {
        TransactionEntity transactionEntity = new TransactionEntity();
        AgentServiceEntity agentServiceEntity = null;
        transactionEntity.setTransactionState(TransactionState.CREATED.getState());
        transactionEntity.setTransactionAccount(defaultAgentRequest.getAccount());
        transactionEntity.setTransactionAmountFromAgent(defaultAgentRequest.getAmount());
        agentServiceEntity = agentServiceRepository.findByServiceId(defaultAgentRequest.getServiceId());
        transactionEntity.setTransactionAmountToMerchant(getMerchantAmount(defaultAgentRequest.getAmount(),agentServiceEntity));
        transactionRepository.save(transactionEntity);

        OsonServiceEntity osonServiceEntity = osonRepository.getById(defaultAgentRequest.getServiceId());
        MerchantServiceEntity merchantServiceEntity = osonServiceEntity.getMerchantServiceEntity();
        MerchantEntity merchantEntity = merchantServiceEntity.getMerchantEntity();


        TransactionEntity transaction = requestToMerchant(merchantServiceEntity, merchantEntity, transactionEntity);
        transactionRepository.save(transaction);

        return BaseCheckResponse.response(
                agentEntity,
                merchantEntity,
                merchantServiceEntity,
                transactionEntity
        );
    }


    private TransactionEntity requestToMerchant(
            MerchantServiceEntity merchantServiceEntity,
            MerchantEntity merchantEntity,
            TransactionEntity transactionEntity
    ) {
        TransactionEntity transaction = null;
        if (merchantEntity.getIsPayme()) {
            transaction = paymeTransactionService.createTransaction(
                    transactionEntity,
                    merchantServiceEntity
            );
        } else if (merchantEntity.getIsYandex()) {
            //TODO
        } else if (merchantEntity.getIsUcell()) {
            //TODO
        }

        return transaction;
    }


    private BigDecimal getMerchantAmount(BigDecimal amount, AgentServiceEntity agentServiceEntity) {
        return amount.subtract(amount.multiply(BigDecimal.valueOf(agentServiceEntity.getCommissionFee())));
    }
}
