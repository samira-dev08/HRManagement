package com.company.mapper;

import com.company.dto.request.ReqContact;
import com.company.entity.Contact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    Contact toContact(ReqContact contact);
}
