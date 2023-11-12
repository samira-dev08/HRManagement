package com.company.dto.response;

import com.company.dto.request.ReqJob;
import com.company.entity.Job;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RespJobPosting {
    private RespJob jobTitle;
    private String requirements;
    private String salaryRange;
    private LocalDate deadline;
}
