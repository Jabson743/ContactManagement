package com.semicolon.africa.service;

import com.semicolon.africa.data.model.Contact;
import com.semicolon.africa.dto.request.AddContactRequest;
import com.semicolon.africa.dto.response.AddContactResponse;

public interface ContactService {
    AddContactResponse add(AddContactRequest addContactRequest);

    Contact findContactByPhoneNumber(String phoneNumber);
}
