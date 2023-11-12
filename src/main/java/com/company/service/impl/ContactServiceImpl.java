package com.company.service.impl;

import com.company.dto.request.ReqContact;
import com.company.entity.Contact;
import com.company.mapper.ContactMapper;
import com.company.repository.ContactRepository;
import com.company.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    @Override
    public Contact addContact(ReqContact reqContact) {
       Contact contact= contactMapper.toContact(reqContact);
       return contactRepository.save(contact);
    }
}
