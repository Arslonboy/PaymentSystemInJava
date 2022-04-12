package com.example.paymentsysteminjava.repository;

import com.example.paymentsysteminjava.entity.MerchantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MerchantRepository extends JpaRepository<MerchantEntity, Long> {

    Optional<MerchantEntity> findByUsername(String username);
}
