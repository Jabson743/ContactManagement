package com.semicolon.africa.service;

import com.semicolon.africa.data.model.Contact;
import com.semicolon.africa.data.repository.ContactRepository;
import com.semicolon.africa.dto.request.AddContactRequest;
import com.semicolon.africa.dto.request.DeleteContactRequest;
import com.semicolon.africa.dto.request.UpdateContactRequest;
import com.semicolon.africa.dto.response.AddContactResponse;
import com.semicolon.africa.dto.response.DeleteContactResponse;
import com.semicolon.africa.dto.response.UpdateContactResponse;
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
        addContactRequest.setFirstName("Boluwatife");
        addContactRequest.setLastName("Olaposi");
        addContactRequest.setEmail("boluwatife@gmail.com");
        addContactRequest.setPhoneNumber("08056351019");
        AddContactResponse addContactResponse = contactService.add(addContactRequest);
        assertEquals(addContactResponse.getMessage(), ("Contact Added Successfully"));
    }

//    @Test
//    public void testFindContactByPhoneNumber() {
//        AddContactRequest addContactRequest = new AddContactRequest();
//        addContactRequest.setFirstName("Ademide");
//        addContactRequest.setLastName("Beauty");
//        addContactRequest.setEmail("ademide@gmail.com");
//        addContactRequest.setPhoneNumber("08056351019");
//        AddContactResponse addContactResponse = contactService.add(addContactRequest);
//        assertEquals(addContactResponse.getMessage(), ("Contact Added Successfully"));
//
//        Contact foundContact = contactService.findContactByPhoneNumber("phoneNumber");
//        assertNotNull(foundContact);
//    }

    @Test
    public void testToUpdateContact() {
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("Boluwatife");
        addContactRequest.setLastName("Olaposi");
        addContactRequest.setEmail("boluwatife@gmail.com");
        addContactRequest.setPhoneNumber("08056351019");
        AddContactResponse addContactResponse = contactService.add(addContactRequest);
        assertEquals(addContactResponse.getMessage(), ("Contact Added Successfully"));

        UpdateContactRequest updateContactRequest = new UpdateContactRequest();
        updateContactRequest.setNewFirstName("Bolu");
        updateContactRequest.setNewLastName("Ola");
        updateContactRequest.setNewEmail("bolu@gmail.com");
        updateContactRequest.setNewPhoneNumber("08056351010");
        UpdateContactResponse updateContactResponse = contactService.update(updateContactRequest);
        assertEquals(updateContactResponse.getMessage(), ("Contact Updated Successfully"));
    }

    @Test
    public void testThatContactCanBeDeleted() {
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("Boluwatife");
        addContactRequest.setLastName("Olaposi"); bjhyun
        addContactRequest.setEmail("boluwatife@gmail.com");
        addContactRequest.setPhoneNumber("08056351019");
        AddContactResponse addContactResponse = contactService.add(addContactRequest);
        assertEquals(addContactResponse.getMessage(), ("Contact Added Successfully"));
        assertEquals(contactRepository.count(), 1);
        DeleteContactRequest deleteContactRequest = new DeleteContactRequest();
        deleteContactRequest.setFirstName("Boluwatife");
        deleteContactRequest.setLastName("Olaposi");
        deleteContactRequest.setEmail("boluwatife@gmail.com");
        deleteContactRequest.setPhoneNumber("08056351019");
        DeleteContactResponse deleteContactResponse = contactService.delete(deleteContactRequest);
        assertEquals(deleteContactResponse.getMessage(), ("Contact Deleted Successfully"));
    }
}