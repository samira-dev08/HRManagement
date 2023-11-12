package com.company.dto.response;

import lombok.Data;

import java.time.LocalDate;
@Data
public class RespTask {
    private String note;
    private LocalDate approximateStartDate;
    private LocalDate approximateEndDate;
}
