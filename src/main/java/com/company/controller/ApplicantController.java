package com.company.controller;

import com.company.dto.request.ReqApplyJob;
import com.company.dto.response.RespJobPosting;
import com.company.service.JobApplyService;
import com.company.service.JobPostingService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/applicant")
@RequiredArgsConstructor
public class ApplicantController {
    private final JobPostingService jobPostingService;
    private final JobApplyService jobApplyService;


    @GetMapping("/available-vacancies")
    public List<RespJobPosting> vacancies() {
        return jobPostingService.getAllActivePosts();
    }

    @PostMapping("/apply-vacancy/{jobPostingId}")
    public ResponseEntity<String> applyVacancy(@PathVariable  Integer jobPostingId,
                                               @RequestParam MultipartFile file,
                                               @RequestParam String email ) {
        String downloadUrl=jobApplyService.saveApplyInfo(jobPostingId,email,file);

        return ResponseEntity.ok("successful apply: "+downloadUrl);
    }
}
