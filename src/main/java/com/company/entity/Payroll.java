package com.company.entity;

import com.company.enums.PayStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;
    private BigDecimal basicSalary;
    private LocalDate startPayPeriod;
    private LocalDate endPayPeriod;
    private BigDecimal overtimePay;
    private BigDecimal bonuses;
    private BigDecimal taxes;// for totalEarnings calculate
    private BigDecimal healthInsurance;//totalEarnings.multiply(BigDecimal.valueOf(0.062))
    private BigDecimal netSalary;
    private LocalDate payDate;
    @Enumerated(value = EnumType.STRING)
    private PayStatus payStatus;

}
