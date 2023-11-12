package com.company.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReqEmployeeInfo {
    private ReqEmployee reqEmployee;
    private ReqContact reqContact;
    private ReqAddress reqAddress;
}
