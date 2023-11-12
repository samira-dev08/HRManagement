package com.company.mapper;

import com.company.dto.request.ReqLeaveReports;
import com.company.dto.response.RespLeaveReports;
import com.company.entity.LeaveReports;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface LeaveReportsMapper {
    LeaveReports toLeaveReports(ReqLeaveReports reqLeaveReports);
    RespLeaveReports toLeaveResponse(LeaveReports leaveReports);
}
