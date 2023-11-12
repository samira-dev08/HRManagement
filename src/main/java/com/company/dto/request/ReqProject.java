package com.company.dto.request;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Lob;
import java.time.LocalDate;
@Data
public class ReqProject {
    private String projectTitle;
    private LocalDate startDate;
    private LocalDate endDate;
    private String projectDetails;
}
