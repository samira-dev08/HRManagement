package com.company.entity;

import com.company.enums.LeaveStatus;
import com.company.enums.LeaveType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeaveReports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "leave_type")
    private LeaveType leaveType;
    @Column(name = "leave_reason")
    private String leaveReason;
    @Column(name = "from_date")
    private LocalDate fromDate;
    @Column(name = "to_date")
    private LocalDate toDate;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "leave_status")
    private LeaveStatus leaveStatus;
}
