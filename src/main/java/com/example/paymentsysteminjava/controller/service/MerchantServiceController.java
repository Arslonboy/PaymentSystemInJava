package com.example.paymentsysteminjava.controller.service;

import com.example.paymentsysteminjava.dto.crud.MerchantServiceDto;
import com.example.paymentsysteminjava.service.merchant_service.MerchantServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/merchant/service")
@RequiredArgsConstructor
public class MerchantServiceController {
    private final MerchantServiceService merchantServiceService;

    @PreAuthorize("hasRole('ROLE_MERCHANT')")
    @PostMapping("/add")
    public ResponseEntity<?> add(
            @RequestBody MerchantServiceDto merchantServiceDto
            ){
        return ResponseEntity.ok(merchantServiceService.add(merchantServiceDto));
    }
}
