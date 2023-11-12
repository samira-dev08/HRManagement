package com.company.service.impl;

import com.company.entity.Attachment;
import com.company.repository.AttachmentRepository;
import com.company.service.AttachmentService;
import com.company.service.JobApplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class AttachmentServiceImpl implements AttachmentService {
    private final AttachmentRepository attachmentRepository;

    @Override
    public Attachment uploadFile(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")) {
                throw new Exception("Filename contains invalid path sequence " + fileName);
            }
            Attachment attachment = new Attachment(fileName, file.getContentType(), file.getBytes());
            return attachmentRepository.save(attachment);
        } catch (Exception ex) {
            throw new Exception("Filename contains invalid path sequence " + fileName);
        }
    }

    @Override
    public Attachment getAttacments(Integer fileId) {
        return attachmentRepository.findById(fileId)
                .orElseThrow(() ->  new RuntimeException("File not found with id " + fileId));
    }
}
