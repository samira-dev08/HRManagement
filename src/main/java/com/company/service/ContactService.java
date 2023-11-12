package com.company.service;

import com.company.dto.request.ReqContact;
import com.company.entity.Contact;

public interface ContactService {
    Contact addContact(ReqContact reqContact);
}
