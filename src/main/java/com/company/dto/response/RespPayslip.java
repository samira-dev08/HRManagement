package com.company.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class RespPayslip {
    private String employeeName;
    private String employeeSurName;
    private String getEmployeeCode;
    private BigDecimal basicSalary;
    private BigDecimal overtimePay;
    private BigDecimal bonuses;
    private BigDecimal totalEarnings;
    private BigDecimal taxes;
    private BigDecimal healthInsurance;
    private BigDecimal totalDeductions;
    private BigDecimal netSalary;
    private String accountNumber;
    private LocalDate payDate;
}
