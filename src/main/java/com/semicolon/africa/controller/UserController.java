package com.semicolon.africa.controller;


import com.semicolon.africa.dto.request.AddUserRequest;
import com.semicolon.africa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register");
    public ResponseEntity<?> addUser(@RequestBody AddUserRequest addUserRequest) {
        try {
            return new ResponseEntity<>(new ApiResponse( true, userService.register(addUserRequest)), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse (false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
