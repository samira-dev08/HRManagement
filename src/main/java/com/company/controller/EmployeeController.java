package com.company.controller;

import com.company.dto.request.ReqLeaveReports;
import com.company.dto.request.ReqTask;
import com.company.dto.response.RespLeaveReports;
import com.company.dto.response.RespPayslip;
import com.company.dto.response.RespTask;
import com.company.entity.LeaveReports;
import com.company.entity.Payroll;
import com.company.entity.Task;
import com.company.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final LeaveReportsService leaveReportsService;
    private final TaskService taskService;
    private final PayrollService payrollService;

    @PostMapping("/create-leave-reports")
    public ResponseEntity<String> createLeaveReports(@RequestParam Integer employeeId, @RequestBody ReqLeaveReports reports) {
        leaveReportsService.createLeaveReports(employeeId,reports);
        return ResponseEntity.ok("success");
    }
    @GetMapping("/leave-reports/{id}")
    public List<RespLeaveReports> getLeaveReports(@PathVariable("id") Integer employeeId) {
        return leaveReportsService.getLeaveReportsByEmpId(employeeId);
        //return ResponseEntity.ok("success");
    }
    @GetMapping("/view-task/{id}")
    public List<RespTask> viewTask(@PathVariable("id") Integer employeeId) {
       return taskService.getTask(employeeId);
    }
    @GetMapping("/view-payslip/{id}")
    public List<RespPayslip> viewPayslip(@PathVariable("id") Integer employeeId) {
        return payrollService.getPayslip(employeeId);

    }

}
