package com.company.dto.response;

import com.company.enums.LeaveStatus;
import com.company.enums.LeaveType;
import lombok.Data;

import java.time.LocalDate;
@Data
public class RespLeaveReports {
    private LeaveType leaveType;
    private String leaveReason;
    private LocalDate fromDate;
    private LocalDate toDate;
    private LeaveStatus leaveStatus;
}
