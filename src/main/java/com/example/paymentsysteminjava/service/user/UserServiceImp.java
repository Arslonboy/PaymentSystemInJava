package com.example.paymentsysteminjava.service.user;

import com.example.paymentsysteminjava.dto.UserRegisterDto;
import com.example.paymentsysteminjava.dto.crud.AddResponseDto;
import com.example.paymentsysteminjava.entity.UserEntity;
import com.example.paymentsysteminjava.exception.LoginValidationException;
import com.example.paymentsysteminjava.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Primary
@Service("u")
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Override
    public AddResponseDto add(UserRegisterDto userRegisterDto) {

        Optional<UserEntity> optionalUser = userRepository.findByUsername(userRegisterDto.getUsername());
        if (optionalUser.isPresent())
            throw new LoginValidationException("username is already exists");

//        UserEntity userEntity = new UserEntity();
//        userEntity.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
//        userEntity.setPermission("ROLE_USER");
//        userEntity.setName(userRegisterDto.getName());
//        userEntity.setUsername(userRegisterDto.getUsername());
        UserEntity userEntity = modelMapper.map(userRegisterDto, UserEntity.class);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userRepository.save(userEntity);
        return new AddResponseDto(1, "added");
    }

    @Override
    public Optional<UserEntity> getUser(Long id) {
        return Optional.empty();
    }


//    public Boolean addSuperAdmin(UserEntity userEntity){
//        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
//        userRepository.save(userEntity);
//        return true;
//    }

}
