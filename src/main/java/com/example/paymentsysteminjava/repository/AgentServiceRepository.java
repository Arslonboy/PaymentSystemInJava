package com.example.paymentsysteminjava.repository;

import com.example.paymentsysteminjava.entity.AgentServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentServiceRepository extends JpaRepository<AgentServiceEntity,Long> {
    
    AgentServiceEntity findByServiceId(long id);
    
    
}
