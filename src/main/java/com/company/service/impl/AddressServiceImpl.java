package com.company.service.impl;

import com.company.dto.request.ReqAddress;
import com.company.entity.Address;
import com.company.mapper.AddressMapper;
import com.company.repository.AddressRepository;
import com.company.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public Address addAddress(ReqAddress reqAddress) {
        Address address=addressMapper.toAddress(reqAddress);
        return addressRepository.save(address);
    }
}
