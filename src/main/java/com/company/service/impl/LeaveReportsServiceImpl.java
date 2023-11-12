package com.company.service.impl;

import com.company.dto.request.ReqLeaveReports;
import com.company.dto.response.RespLeaveReports;
import com.company.entity.Employee;
import com.company.entity.LeaveReports;
import com.company.enums.LeaveStatus;
import com.company.exception.LeaveReportsNotFoundException;
import com.company.mapper.LeaveReportsMapper;
import com.company.repository.EmployeeRepository;
import com.company.repository.LeaveReportsRepository;
import com.company.service.EmployeeService;
import com.company.service.LeaveReportsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LeaveReportsServiceImpl implements LeaveReportsService {
    private final LeaveReportsRepository leaveReportsRepository;
    private final LeaveReportsMapper reportsMapper;
    private final EmployeeService employeeService;

    @Override
    public LeaveReports createLeaveReports(Integer employeeId, ReqLeaveReports reqLeaveReports) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        LeaveReports leaveReports = reportsMapper.toLeaveReports(reqLeaveReports);
        leaveReports.setEmployee(employee);
        leaveReports.setLeaveStatus(LeaveStatus.PENDING);
        return leaveReportsRepository.save(leaveReports);
    }

    @Override
    public List<RespLeaveReports> getLeaveReportsByEmpId(Integer employeeId) {
        employeeService.getEmployeeById(employeeId);
        List<LeaveReports> listReports=leaveReportsRepository.findByEmployeeId(employeeId).get();
        if(listReports.isEmpty()){
            throw new LeaveReportsNotFoundException("Not found Leave Reports for this Employee");
        }

        return listReports.stream().
                map(leaveReports -> reportsMapper.toLeaveResponse(leaveReports))
                .collect(Collectors.toList());
    }

    @Override
    public List<RespLeaveReports> searchLeaveReports(String query) {
        List<LeaveReports> leaveReportsList= leaveReportsRepository
                .searchLeaveReports(query).get();
        if(leaveReportsList.isEmpty()){
            throw new LeaveReportsNotFoundException("Not found Leave Reports for this search");
        }
        return leaveReportsList.stream().
                map(leaveReports -> reportsMapper.toLeaveResponse(leaveReports))

                .collect(Collectors.toList());
    }
}
