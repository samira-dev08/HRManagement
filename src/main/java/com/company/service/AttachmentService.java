package com.company.service;

import com.company.entity.Attachment;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {
    Attachment uploadFile(MultipartFile multipartFile) throws Exception;
    Attachment getAttacments(Integer fileId) throws Exception;
}
