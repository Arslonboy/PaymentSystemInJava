package com.example.paymentsysteminjava.service.merchant;

import com.example.paymentsysteminjava.dto.UserRegisterDto;
import com.example.paymentsysteminjava.dto.crud.AddResponseDto;
import com.example.paymentsysteminjava.entity.MerchantEntity;
import com.example.paymentsysteminjava.entity.UserEntity;
import com.example.paymentsysteminjava.exception.LoginValidationException;
import com.example.paymentsysteminjava.repository.MerchantRepository;
import com.example.paymentsysteminjava.repository.UserRepository;
import com.example.paymentsysteminjava.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MerchantService implements UserService {

    private final MerchantRepository merchantRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AddResponseDto add(UserRegisterDto userRegisterDto) {

        Optional<MerchantEntity> optionalUser = merchantRepository.findByUsername(userRegisterDto.getUsername());
        if (optionalUser.isPresent())
            throw new LoginValidationException("username is already exists");

        MerchantEntity merchantEntity = new MerchantEntity();
        merchantEntity.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        merchantEntity.setPermission("ROLE_USER");
        merchantEntity.setName(userRegisterDto.getName());
        merchantEntity.setUsername(userRegisterDto.getUsername());
        merchantRepository.save(merchantEntity);
        return new AddResponseDto(1, "added");
    }

    @Override
    public Optional<UserEntity> getUser(Long id) {
        return Optional.empty();
    }



}
