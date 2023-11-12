package com.company.service;

import com.company.dto.request.ReqLeaveReports;
import com.company.dto.response.RespLeaveReports;
import com.company.entity.LeaveReports;

import java.util.List;

public interface LeaveReportsService {
    LeaveReports createLeaveReports(Integer employeeId, ReqLeaveReports reqLeaveReports);
    List<RespLeaveReports> getLeaveReportsByEmpId(Integer employeeId);


    List<RespLeaveReports> searchLeaveReports(String query);
}
