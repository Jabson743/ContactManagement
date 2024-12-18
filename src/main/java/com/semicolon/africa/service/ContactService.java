package com.semicolon.africa.service;

import com.semicolon.africa.data.model.Contact;
import com.semicolon.africa.dto.request.AddContactRequest;
import com.semicolon.africa.dto.request.DeleteContactRequest;
import com.semicolon.africa.dto.request.UpdateContactRequest;
import com.semicolon.africa.dto.response.AddContactResponse;
import com.semicolon.africa.dto.response.DeleteContactResponse;
import com.semicolon.africa.dto.response.UpdateContactResponse;

public interface ContactService {

    AddContactResponse add(AddContactRequest addContactRequest);

    UpdateContactResponse update(UpdateContactRequest updateContactRequest);

    DeleteContactResponse delete(DeleteContactRequest deleteContactRequest);

    Contact findContactByPhoneNumber(String phoneNumber);
}
