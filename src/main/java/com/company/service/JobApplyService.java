package com.company.service;

import com.company.dto.request.ReqApplyJob;
import com.company.entity.Attachment;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface JobApplyService {
       String saveApplyInfo(Integer jobPostingId, String email, MultipartFile file);

       List<Attachment> getAttacments(Integer jobPostingId);
}
