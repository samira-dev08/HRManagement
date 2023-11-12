package com.company.dto.request;

import com.company.entity.Employee;
import com.company.entity.Project;
import lombok.Data;


import java.time.LocalDate;
@Data
public class ReqTask {
//    private Employee employee;
//    private Project project;
    private String note;
    private LocalDate approximateStartDate;
    private LocalDate approximateEndDate;
}
