package com.company.controller;

import com.company.dto.request.*;
import com.company.dto.response.RespEmployee;
import com.company.dto.response.RespLeaveReports;
import com.company.entity.Attachment;
import com.company.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/manager")
@RequiredArgsConstructor
public class ManagerController {
    private final EmployeeService employeeService;
    private final LeaveReportsService leaveReportsService;
    private final JobPostingService jobPostingService;
    private final ProjectService projectService;
    private final TaskService taskService;
    private final PayrollService payrollService;
    private final JobApplyService jobApplyService;


    @GetMapping("/download/{jobPostingId}")
    public List<ResponseEntity<Resource>> viewApplicantsFile(@PathVariable Integer jobPostingId) throws Exception {
        List<Attachment> attachmentList = jobApplyService.getAttacments(jobPostingId);
        List<ResponseEntity<Resource>> dataList=new ArrayList<>();
        for (Attachment attachment: attachmentList) {
            dataList.add(ResponseEntity.ok().contentType(MediaType.parseMediaType(attachment.getFileType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + attachment.getFileName() + "\"")
                    .body(new ByteArrayResource(attachment.getData())));
        }
        return dataList;
    }

    @PostMapping("/create-employee")
    public ResponseEntity<String> createEmployee(@RequestBody ReqEmployeeInfo reqEmployeeInfo) {
        employeeService.createEmployee(reqEmployeeInfo);
        return ResponseEntity.ok("success");
    }

    @PostMapping("/create-job-post")
    public ResponseEntity<String> createJobPost(@RequestParam Integer jobId, @RequestBody ReqJobPosting reqJobPosting) {
        jobPostingService.createJobPost(jobId, reqJobPosting);
        return ResponseEntity.ok("success");
    }

    @DeleteMapping("/delete-job-post/{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") Integer jobPostId) {
        jobPostingService.deleteJobPost(jobPostId);
        return ResponseEntity.ok("success");
    }

    @PostMapping("/create-project")
    public ResponseEntity<String> createProject(@RequestBody ReqProject reqProject) {
        projectService.createProject(reqProject);
        return ResponseEntity.ok("success");
    }

    @PostMapping("/create-task")
    public ResponseEntity<String> createTask(@RequestParam Integer employeeId,
                                             @RequestParam Integer projectId,
                                             @RequestBody ReqTask reqTask) {
        taskService.createTask(employeeId, projectId, reqTask);
        return ResponseEntity.ok("success");
    }

    @GetMapping("/search-employee")
    public List<RespEmployee> search(@RequestParam String query) {
        return employeeService.searchEmployee(query);
    }

    @GetMapping("/search-leave-reports")
    public List<RespLeaveReports> searchLeaveReports(@RequestParam String query) {
        return leaveReportsService.searchLeaveReports(query);
    }

    @PostMapping("/payroll")
    public ResponseEntity<String> payroll(@RequestParam Integer employeeId,
                                          @RequestBody ReqPayroll reqPayroll) {
        payrollService.calculatePayroll(employeeId, reqPayroll);
        return ResponseEntity.ok("success");
    }


}
