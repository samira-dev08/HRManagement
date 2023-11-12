package com.company.mapper;

import com.company.dto.request.ReqAddress;
import com.company.entity.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address toAddress(ReqAddress address);
}
