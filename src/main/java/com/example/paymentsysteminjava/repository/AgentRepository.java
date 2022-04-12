package com.example.paymentsysteminjava.repository;

import com.example.paymentsysteminjava.entity.AgentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AgentRepository extends JpaRepository<AgentEntity, Long> {

    @Query("select a from AgentEntity a where a.username = ?1 and a.isActive = true ")
    AgentEntity findByUsername(String username);

    @Query("select a from AgentEntity a where a.id = ?1 and a.isActive = true ")
    Optional<AgentEntity> checkAgent(Long id);


}
