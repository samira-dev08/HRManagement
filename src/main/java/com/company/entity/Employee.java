package com.company.entity;

import com.company.enums.EmploymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String employeeCode;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private String gender;
    @OneToOne
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;
    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @OneToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Job position;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "employment_status")
    private EmploymentStatus employmentStatus;
    private BigDecimal salary;
    @Column(name = "hire_date")
    private LocalDate hireDate;
    @OneToMany(mappedBy = "employee")
    private List<LeaveReports> leaveReportsList;
    @OneToMany(mappedBy = "employee")
    private List<Task> taskList;
    private boolean isActive;
}
