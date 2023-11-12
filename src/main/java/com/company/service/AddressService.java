package com.company.service;

import com.company.dto.request.ReqAddress;
import com.company.entity.Address;

public interface AddressService {
    Address addAddress(ReqAddress reqAddress);
}
