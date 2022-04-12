package com.example.paymentsysteminjava.service.merchant_service;

import com.example.paymentsysteminjava.dto.crud.AddResponseDto;
import com.example.paymentsysteminjava.dto.crud.MerchantServiceDto;
import com.example.paymentsysteminjava.entity.MerchantEntity;
import com.example.paymentsysteminjava.entity.MerchantServiceEntity;
import com.example.paymentsysteminjava.repository.MerchantServiceRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MerchantServiceServiceImp implements MerchantServiceService{

    private final MerchantServiceRepository merchantServiceRepository;
    private final ModelMapper modelMapper;

    @Override
    public AddResponseDto add(MerchantServiceDto merchantServiceDto) {
        if(merchantServiceRepository.findById(merchantServiceDto.getId()).isPresent())
            return new AddResponseDto(11,"Service with this id already exist");

        MerchantServiceEntity merchantService = modelMapper.map(merchantServiceDto, MerchantServiceEntity.class);


//        merchantService.setMerchantEntity();
        merchantServiceRepository.save(merchantService);
        return new AddResponseDto(1,"Service added");
    }
}
