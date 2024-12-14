package com.semicolon.africa.dto.request;


import lombok.Data;

@Data
public class AddContactRequest {
    private String userName;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
}
