package com.company.dto.request;

import lombok.Data;

@Data
public class SignupRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
}
