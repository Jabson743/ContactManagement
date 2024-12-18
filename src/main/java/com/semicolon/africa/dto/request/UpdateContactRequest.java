package com.semicolon.africa.dto.request;

import lombok.Data;

@Data
public class UpdateContactRequest {
    private String userName;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String newFirstName;
    private String newLastName;
    private String newPhoneNumber;
    private String newEmail;
    private String newUserName;
}
