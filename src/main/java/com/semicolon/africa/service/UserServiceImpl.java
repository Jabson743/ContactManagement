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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public AddUserResponse register(AddUserRequest userRequest) {
        //validateEmail(userRequest.getEmail());
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        userRepository.save(user);

        AddUserResponse response = new AddUserResponse();
        response.setMessage("Registration Successful");
        return response;
    }

//    private void validateEmail(String email) throws UserAlreadyExistExceptions {
//        User user = userRepository.findByEmail(email);
//        if (user != null) {
//            throw new UserAlreadyExistExceptions("Email already exist");
//        }
//    }

    @Override
    public UserLoginResponse login(UserLoginRequest userLoginRequest) {
        String email = userLoginRequest.getEmail();
        String password = userLoginRequest.getPassword();

        for (User user : userRepository.findAll()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                user.setLoggedIn(true);
                userRepository.save(user);
                UserLoginResponse response = new UserLoginResponse();
                response.setMessage("Login Successful");
                return response;
            }
        }

        return null;
    }

    @Override
    public AddContactResponse addContact(AddContactRequest addContactRequest) {
        addContactRequest.setFirstName(addContactRequest.getFirstName());
        addContactRequest.setLastName(addContactRequest.getLastName());
        addContactRequest.setEmail(addContactRequest.getEmail());
        addContactRequest.setPhoneNumber(addContactRequest.getPhoneNumber());
        userRepository.save(new User());

        AddContactResponse response = new AddContactResponse();
        response.setMessage("Contact Added Successful");
        return response;
    }

//    @Override
//    public User findUserByEmail(String mail) {
//        return null;
//    }

}
