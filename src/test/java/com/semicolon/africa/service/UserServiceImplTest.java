package com.semicolon.africa.service;

import com.semicolon.africa.data.model.User;
import com.semicolon.africa.data.repository.UserRepository;
import com.semicolon.africa.dto.request.AddContactRequest;
import com.semicolon.africa.dto.request.AddUserRequest;
import com.semicolon.africa.dto.request.UserLoginRequest;
import com.semicolon.africa.dto.response.AddContactResponse;
import com.semicolon.africa.dto.response.AddUserResponse;
import com.semicolon.africa.dto.response.UserLoginResponse;
import com.semicolon.africa.exceptions.UserAlreadyExistExceptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserServiceImpl userServiceImpl;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void testToAddUser() {
        AddUserRequest addUserRequest = new AddUserRequest();
        addUserRequest.setFirstName("Jabson");
        addUserRequest.setLastName("Olakunle");
        addUserRequest.setEmail("jabson@gmail.com");
        addUserRequest.setUsername("jabson");
        addUserRequest.setPassword("12345");

        AddUserResponse userResponse = userService.register(addUserRequest);
        assertEquals(userResponse.getMessage(), "Registration Successful");
    }

    @Test
    public void testThatUserCanLogin() {
        AddUserRequest addUserRequest = new AddUserRequest();
        addUserRequest.setFirstName("Jabson");
        addUserRequest.setLastName("Olakunle");
        addUserRequest.setEmail("jabson@gmail.com");
        addUserRequest.setUsername("jabson");
        addUserRequest.setPassword("12345");

        AddUserResponse userResponse = userService.register(addUserRequest);
        assertEquals(userResponse.getMessage(), "Registration Successful");

        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setEmail("jabson@gmail.com");
        userLoginRequest.setPassword("12345");
        UserLoginResponse loginResponse = userService.login(userLoginRequest);
        assertEquals(loginResponse.getMessage(), "Login Successful");
    }

    @Test
    public void testThatUserCanAddContact() {
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("Zainab");
        addContactRequest.setLastName("Olabisi");
        addContactRequest.setEmail("zainab@gmail.com");
        addContactRequest.setPhoneNumber("08022880118");
        AddContactResponse addContactResponse = userService.addContact(addContactRequest);
        assertEquals(addContactResponse.getMessage(), "Contact Added Successful");
    }

//    @Test
//    public void testToFindUser() {
//        AddUserRequest addUserRequest = new AddUserRequest();
//        addUserRequest.setFirstName("Jabson");
//        addUserRequest.setLastName("Olakunle");
//        addUserRequest.setEmail("jabson@gmail.com");
//        addUserRequest.setUsername("jabson");
//        addUserRequest.setPassword("12345");
//        AddUserResponse userResponse = userService.register(addUserRequest);
//        assertEquals(userResponse.getMessage(), "Registration Successful");
//
//        User user = userService.findUserByEmail("jabson@gmail.com");
//        assertEquals(user.getEmail().equals("jabson@gmail.com"));
//
//    }

//    @Test
//    public void testThatEmailIsUniqueToSingleUser() {
//        AddUserRequest addUserRequest = new AddUserRequest();
//        addUserRequest.setFirstName("Jabson");
//        addUserRequest.setLastName("Olakunle");
//        addUserRequest.setEmail("jabson@gmail.com");
//        addUserRequest.setUsername("jabson");
//        addUserRequest.setPassword("12345");
//        AddUserResponse addUserResponse = userService.register(addUserRequest);
//        assertEquals(addUserResponse.getMessage(), "Registration Successful");
//
//        assertThrows(UserAlreadyExistExceptions.class, () -> userService.register(addUserRequest));
//    }

}