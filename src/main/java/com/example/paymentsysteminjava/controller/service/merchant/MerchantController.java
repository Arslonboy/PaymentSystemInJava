package com.example.paymentsysteminjava.controller.service.merchant;

import com.example.paymentsysteminjava.dto.UserRegisterDto;
import com.example.paymentsysteminjava.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/merchant/")
@RequiredArgsConstructor
public class MerchantController {
    private final UserService merchantService;

    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
    @PostMapping("/register")
    public ResponseEntity<?> add(@RequestBody UserRegisterDto userRegisterDto) {

        return ResponseEntity.ok().body(merchantService.add(userRegisterDto));
//        return ResponseEntity.status(HttpStatus.CONFLICT).body("Something is wrong");
    }

}
