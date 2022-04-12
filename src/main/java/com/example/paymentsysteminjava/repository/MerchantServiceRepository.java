package com.example.paymentsysteminjava.repository;

import com.example.paymentsysteminjava.entity.MerchantServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantServiceRepository extends JpaRepository<MerchantServiceEntity, Long> {
//    MerchantServiceEntity findByMerchantEntityAndId(Long merchantId, Long id);
}
