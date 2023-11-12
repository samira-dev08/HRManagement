package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "job_title")
    private String jobTitle;
    @Lob
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id",referencedColumnName = "id")
    private Department department;
    @Column(name = "min_salary")
    private BigDecimal minSalary;
    @Column(name = "max_salary")
    private BigDecimal maxSalary;

}
