package com.example.paymentsysteminjava.service.gateway;

import com.example.paymentsysteminjava.dto.request.gateway.payme.PaymeCheckTransactionRequestDto;
import com.example.paymentsysteminjava.dto.response.gateway.payme.PaymeCheckTransactioniResponseDto;
import com.example.paymentsysteminjava.entity.MerchantServiceEntity;
import com.example.paymentsysteminjava.entity.transaction.TransactionEntity;
import com.example.paymentsysteminjava.entity.transaction.TransactionState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PaymeTransactionService {
    private final RestTemplate restTemplate;

    public TransactionEntity createTransaction(
            TransactionEntity transactionEntity,
            MerchantServiceEntity merchantServiceEntity
    ){
        PaymeCheckTransactionRequestDto paymeCheckTransactionRequestDto = new PaymeCheckTransactionRequestDto(
                merchantServiceEntity.getId(),
                Timestamp.valueOf(String.valueOf(LocalDate.now())),
                transactionEntity.getTransactionAccount(),
                transactionEntity.getTransactionAmountToMerchant()
        );

        try {
            PaymeCheckTransactioniResponseDto paymeCheckTransactionRequestDto1 = restTemplate.postForObject(
                    "",
                    paymeCheckTransactionRequestDto,
                    PaymeCheckTransactioniResponseDto.class
            );
            assert paymeCheckTransactionRequestDto1 != null;
            PaymeCheckTransactioniResponseDto.Result result = paymeCheckTransactionRequestDto1.getResult();
            if (result.getState() == 1){
                transactionEntity.setTransactionState(TransactionState.CHECKED.getState());
            } else {
                transactionEntity.setTransactionState(TransactionState.CHECK_ERROR.getState());
            }
            return transactionEntity;

        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
