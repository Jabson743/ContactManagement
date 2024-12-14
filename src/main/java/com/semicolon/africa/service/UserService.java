package com.semicolon.africa.service;

import com.semicolon.africa.data.model.User;
import com.semicolon.africa.dto.request.AddContactRequest;
import com.semicolon.africa.dto.request.AddUserRequest;
import com.semicolon.africa.dto.request.UserLoginRequest;
import com.semicolon.africa.dto.response.AddContactResponse;
import com.semicolon.africa.dto.response.AddUserResponse;
import com.semicolon.africa.dto.response.UserLoginResponse;

public interface UserService {
    AddUserResponse register (AddUserRequest userRequest);

    UserLoginResponse login (UserLoginRequest userLoginRequest);

    AddContactResponse addContact(AddContactRequest addContactRequest);

//    User findUserByEmail(String mail);
}
