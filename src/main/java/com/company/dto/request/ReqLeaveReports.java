package com.company.dto.request;

import com.company.entity.Employee;
import com.company.enums.LeaveType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
@Data

public class ReqLeaveReports {
   // private Employee employee;
    private LeaveType leaveType;
    private String leaveReason;
    private LocalDate fromDate;
    private LocalDate toDate;
}
