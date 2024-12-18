package com.semicolon.africa.service;

import com.semicolon.africa.data.model.Contact;
import com.semicolon.africa.data.repository.ContactRepository;
import com.semicolon.africa.dto.request.AddContactRequest;
import com.semicolon.africa.dto.request.DeleteContactRequest;
import com.semicolon.africa.dto.request.UpdateContactRequest;
import com.semicolon.africa.dto.response.AddContactResponse;
import com.semicolon.africa.dto.response.DeleteContactResponse;
import com.semicolon.africa.dto.response.UpdateContactResponse;
import com.semicolon.africa.exceptions.ContactNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public AddContactResponse add(AddContactRequest addContactRequest) {
        Contact contact = new Contact();
        contact.setFirstName(addContactRequest.getFirstName());
        contact.setLastName(addContactRequest.getLastName());
        contact.setEmail(addContactRequest.getEmail());
        contact.setPhoneNumber(addContactRequest.getPhoneNumber());
        contactRepository.save(contact);
        AddContactResponse addContactResponse = new AddContactResponse();
        addContactResponse.setMessage("Contact Added Successfully");
        return addContactResponse;
    }

    @Override
    public UpdateContactResponse update(UpdateContactRequest updateContactRequest) {
        Contact contact = new Contact();
        contact.setFirstName(updateContactRequest.getNewFirstName());
        contact.setLastName(updateContactRequest.getNewLastName());
        contact.setEmail(updateContactRequest.getNewEmail());
        contact.setPhoneNumber(updateContactRequest.getNewPhoneNumber());
        contactRepository.save(contact);

        UpdateContactResponse updateContactResponse = new UpdateContactResponse();
        updateContactResponse.setMessage("Contact Updated Successfully");

        return updateContactResponse;
    }

    @Override
    public DeleteContactResponse delete(DeleteContactRequest deleteContactRequest) {
        Contact contact = new Contact();
        contact.setFirstName(deleteContactRequest.getFirstName());
        contact.setLastName(deleteContactRequest.getLastName());
        contact.setEmail(deleteContactRequest.getEmail());
        contact.setPhoneNumber(deleteContactRequest.getPhoneNumber());
        contactRepository.delete(contact);

        DeleteContactResponse deleteContactResponse = new DeleteContactResponse();
        deleteContactResponse.setMessage("Contact Deleted Successfully");
        return deleteContactResponse;
    }

    @Override
    public Contact findContactByPhoneNumber(String phoneNumber) {
        for (Contact contact : contactRepository.findAll()) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        throw new ContactNotFoundException("Contact does not exist");
    }
}
