package com.semicolon.africa.dto.response;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class UpdateContactResponse {
    private String message;
}