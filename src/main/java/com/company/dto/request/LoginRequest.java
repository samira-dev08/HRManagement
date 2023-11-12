package com.company.dto.request;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

@Data
public class LoginRequest {
    @NotNull
    @Email
    @Length(min = 5, max = 50)
    private String username;
    @NotNull
    @Length(min = 5, max = 10)
    private String password;
}
