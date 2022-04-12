package com.example.paymentsysteminjava.controller.auth;

import com.example.paymentsysteminjava.dto.UserLoginDto;
import com.example.paymentsysteminjava.dto.UserRegisterDto;
import com.example.paymentsysteminjava.dto.response.ApiJwtResponse;
import com.example.paymentsysteminjava.entity.UserEntity;
import com.example.paymentsysteminjava.repository.UserRepository;
import com.example.paymentsysteminjava.service.jwt.JwtProvider;
import com.example.paymentsysteminjava.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/")
@RequiredArgsConstructor
public class AuthController {

    private final JwtProvider jwtProvider;

    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @PostMapping("/agent_login")
    public ResponseEntity<?> login(@RequestBody UserLoginDto userLoginDto) {
        UserEntity agentEntity =  userService.login(userLoginDto,userRepository,passwordEncoder);
        String accessToken = jwtProvider.generateAccessToken(agentEntity.getUsername(), agentEntity.getPermission());
        String refreshToken = jwtProvider.generateRefreshToken(agentEntity);

        return ResponseEntity.ok().body(new ApiJwtResponse(1, accessToken, refreshToken));
    }

    @PostMapping("/user_login")
    public ResponseEntity<?> getToken(@RequestBody UserLoginDto userLoginDto) {
        UserEntity userEntity =  userService.login(userLoginDto,userRepository,passwordEncoder);
        String accessToken = jwtProvider.generateAccessToken(userEntity.getUsername(), userEntity.getPermission());
        String refreshToken = jwtProvider.generateRefreshToken(userEntity);

        return ResponseEntity.ok().body(new ApiJwtResponse(1, accessToken, refreshToken));
    }

//    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
    @PostMapping("/refresh_token")
    public ResponseEntity<?> getRefreshToken(@RequestBody String token) {
        String accessToken = jwtProvider.getAccessTokenFromRefreshToken(token);
        return ResponseEntity.ok().body(new ApiJwtResponse(1, accessToken, token));
    }

    @PostMapping("/add_admin")
    public ResponseEntity<?> addAdmin(
            @RequestBody UserRegisterDto userRegisterDto
            ){
        return ResponseEntity.ok(userService.add(userRegisterDto));
    }

//    @PostMapping("/add_admin")
//    public ResponseEntity<Boolean> addSuperAdmin(@RequestBody UserEntity userEntity){
//        return ResponseEntity.ok(userService.addSuperAdmin(userEntity));
//    }


}
