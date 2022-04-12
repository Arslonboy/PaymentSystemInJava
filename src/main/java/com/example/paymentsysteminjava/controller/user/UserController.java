package com.example.paymentsysteminjava.controller.user;

import com.example.paymentsysteminjava.dto.UserRegisterDto;
import com.example.paymentsysteminjava.service.jwt.JwtProvider;
import com.example.paymentsysteminjava.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user/")
public class UserController {

    @Qualifier("u")
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;


    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody UserRegisterDto userRegisterDto){
        return ResponseEntity.ok(userService.add(userRegisterDto));
    }

}
