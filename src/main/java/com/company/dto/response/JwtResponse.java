package com.company.dto.response;

import com.company.enums.Authority;
import lombok.Data;

@Data
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private Authority role;
}
