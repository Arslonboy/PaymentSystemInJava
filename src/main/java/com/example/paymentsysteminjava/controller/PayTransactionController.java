package com.example.paymentsysteminjava.controller;


import com.example.paymentsysteminjava.dto.response.agent.BaseAgentResponse;
import com.example.paymentsysteminjava.repository.AgentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction/")
@RequiredArgsConstructor
public class PayTransactionController {


    private final AgentRepository agentRepository;

    @PreAuthorize("hasRole('ROLE_AGENT')")
    @RequestMapping("pay/{transactionId}")
    public BaseAgentResponse pay(
            @PathVariable
            String transactionId,
            @AuthenticationPrincipal
            String username
    ) {
        
        agentRepository.findByUsername(username);
        return null;
    }

}
