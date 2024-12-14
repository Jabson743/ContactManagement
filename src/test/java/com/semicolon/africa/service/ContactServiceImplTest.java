package com.semicolon.africa.service;

import com.semicolon.africa.data.model.Contact;
import com.semicolon.africa.data.repository.ContactRepository;
import com.semicolon.africa.dto.request.AddContactRequest;
import com.semicolon.africa.dto.response.AddContactResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ContactServiceImplTest {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactRepository.deleteAll();
    }

    @Test
    public void testAddContact() {
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("Ademide");
        addContactRequest.setLastName("Beauty");
        addContactRequest.setEmail("ademide@gmail.com");
        addContactRequest.setPhoneNumber("08056351019");
        AddContactResponse addContactResponse = contactService.add(addContactRequest);
        assertEquals(addContactResponse.getMessage(), ("Contact Added Successfully"));
    }

    @Test
    public void testFindContactByPhoneNumber() {
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("Ademide");
        addContactRequest.setLastName("Beauty");
        addContactRequest.setEmail("ademide@gmail.com");
        addContactRequest.setPhoneNumber("08056351019");
        AddContactResponse addContactResponse = contactService.add(addContactRequest);
        assertEquals(addContactResponse.getMessage(), ("Contact Added Successfully"));

        Contact foundContact = contactService.findContactByPhoneNumber("phoneNumber");
        assertNotNull(foundContact);
    }

}