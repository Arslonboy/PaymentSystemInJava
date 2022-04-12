package com.example.paymentsysteminjava.service.agent;

import com.example.paymentsysteminjava.dto.UserRegisterDto;
import com.example.paymentsysteminjava.dto.crud.AddResponseDto;
import com.example.paymentsysteminjava.dto.response.AgentRegisterDto;
import com.example.paymentsysteminjava.entity.AgentEntity;
import com.example.paymentsysteminjava.entity.UserEntity;
import com.example.paymentsysteminjava.exception.LoginValidationException;
import com.example.paymentsysteminjava.repository.AgentRepository;
import com.example.paymentsysteminjava.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service("a")
@RequiredArgsConstructor
public class AgentServiceImp implements UserService {

    private final AgentRepository agentRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Override
    public AddResponseDto add(UserRegisterDto agentRegisterDto) {
        AgentEntity agentEntity1 = agentRepository.findByUsername(agentRegisterDto.getUsername());
        if (agentEntity1 != null)
            throw new LoginValidationException("username is already exists");

//        AgentEntity agentEntity = new AgentEntity();
//        agentEntity.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
//        agentEntity.setPermission(userRegisterDto.getPermission().get(0));
//        agentEntity.setName(userRegisterDto.getName());
//        agentEntity.setUsername(userRegisterDto.getUsername());
        AgentEntity agentEntity = modelMapper.map(agentRegisterDto, AgentEntity.class);
        agentEntity.setPassword(passwordEncoder.encode(agentEntity.getPassword()));
        agentRepository.save(agentEntity);
        return new AddResponseDto(1, "added");
    }

    @Override
    public Optional<UserEntity> getUser(Long id) {
        return Optional.empty();
    }


}
