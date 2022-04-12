package com.example.paymentsysteminjava.controller;

import com.example.paymentsysteminjava.dto.request.agent.DefaultAgentRequest;
import com.example.paymentsysteminjava.dto.response.agent.BaseAgentResponse;
import com.example.paymentsysteminjava.entity.AgentEntity;
import com.example.paymentsysteminjava.repository.AgentRepository;
import com.example.paymentsysteminjava.service.transaction.CheckTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction")
@RequiredArgsConstructor
public class CheckTransactionController {

    private final CheckTransactionService checkTransactionService;

    private final AgentRepository agentRepository;

    @PreAuthorize("hasRole('ROLE_AGENT')")
    @PostMapping("/check")
    public BaseAgentResponse checkTransaction(
            @RequestBody DefaultAgentRequest baseAgentRequest,
            @AuthenticationPrincipal String username
    ) {

        AgentEntity byUsername = agentRepository.findByUsername(username);

        return checkTransactionService.check(baseAgentRequest, byUsername);

    }
}
