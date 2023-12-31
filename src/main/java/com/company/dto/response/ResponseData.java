package com.company.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData {
    private String applicantFullname;
    private String email;
    private String fileName;
    private String downloadUrl;
    private String fileType;
    private  long fileSize;
}
