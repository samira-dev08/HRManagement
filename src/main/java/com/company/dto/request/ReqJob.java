package com.company.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
@Data
@AllArgsConstructor
public class ReqJob {
    private String jobTitle;
    private String description;
    private ReqDepartment department;
    private BigDecimal minSalary;
    private BigDecimal maxSalary;
}
