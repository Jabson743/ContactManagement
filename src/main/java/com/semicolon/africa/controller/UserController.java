package com.semicolon.africa.controller;


import com.semicolon.africa.dto.request.AddUserRequest;
import com.semicolon.africa.dto.response.AddUserResponse;
import com.semicolon.africa.exceptions.UserAlreadyExistExceptions;
import com.semicolon.africa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody AddUserRequest addUserRequest) {
        try {
            AddUserResponse addUserResponse = userService.register(addUserRequest);
            return new ResponseEntity<>(addUserResponse.toString(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

