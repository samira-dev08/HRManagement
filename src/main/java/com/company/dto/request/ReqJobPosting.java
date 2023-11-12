package com.company.dto.request;

import com.company.entity.Job;
import lombok.Data;
import java.time.LocalDate;
@Data
public class ReqJobPosting {
    private String requirements;
    private String salaryRange;
    private LocalDate deadline;
}
