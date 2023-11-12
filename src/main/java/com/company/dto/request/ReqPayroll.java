package com.company.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class ReqPayroll {
    private LocalDate startPayPeriod;
    private LocalDate endPayPeriod;
    private BigDecimal overtimePay;
    private BigDecimal bonuses;
}
