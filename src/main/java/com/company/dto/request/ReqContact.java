package com.company.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReqContact {
    private String homeNumber;
    private String mobile;
    private String email;
}
