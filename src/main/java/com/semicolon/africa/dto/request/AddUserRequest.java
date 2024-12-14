package com.semicolon.africa.dto.request;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class AddUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
}
