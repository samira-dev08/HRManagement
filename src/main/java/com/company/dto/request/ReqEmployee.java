package com.company.dto.request;

import com.company.entity.Address;
import com.company.entity.Contact;
import com.company.entity.Job;
import com.company.enums.EmploymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.id.IntegralDataTypeHolder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@AllArgsConstructor
public class ReqEmployee {
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private String gender;
    private Integer jobId;
    private EmploymentStatus employmentStatus;
    private BigDecimal salary;
    private LocalDate hireDate;
}
