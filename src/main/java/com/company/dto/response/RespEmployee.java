package com.company.dto.response;

import com.company.dto.request.ReqAddress;
import com.company.dto.request.ReqContact;
import com.company.dto.request.ReqJob;
import com.company.enums.EmploymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class RespEmployee {
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private String gender;
    private ReqContact contact;
    private ReqAddress address;
    private ReqJob position;
    private EmploymentStatus employmentStatus;
    private BigDecimal salary;
    private LocalDate hireDate;
}
