package com.company.service.impl;

import com.company.dto.request.ReqApplyJob;
import com.company.entity.Attachment;
import com.company.entity.JobApplication;
import com.company.entity.JobPosting;
import com.company.enums.ApplicationStatus;
import com.company.repository.JobApplicationRepository;
import com.company.service.AttachmentService;
import com.company.service.JobApplyService;
import com.company.service.JobPostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplyServiceImpl implements JobApplyService {
    private final JobPostingService jobPostingService;
    private final AttachmentService attachmentService;
    private final JobApplicationRepository jobApplicationRepository;
    private final MailService mailService;

    @Override
    public String saveApplyInfo(Integer jobPostingId, String email, MultipartFile file) {
        JobPosting jobPosting = jobPostingService.getJobPosting(jobPostingId);
        String downloadUrl = "";
        try {
            Attachment attachment = attachmentService.uploadFile(file);
            JobApplication jobApply = new JobApplication(
                    email,
                    jobPosting,
                    attachment,
                    ApplicationStatus.NEW
            );
            jobApplicationRepository.save(jobApply);
            downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/v1/manager/download/").path(attachment.getId().toString()).toUriString();
            return downloadUrl;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Attachment> getAttacments(Integer jobPostingId) {
       return  jobApplicationRepository.findAttachmentByJobPostingId(jobPostingId)
                .orElseThrow(() -> new RuntimeException("Not found any apply"));
    }

    @Scheduled(fixedDelay = 3000, initialDelay = 1000)
    public void sendEmailByThread() {
        List<JobApplication> listJobApply = jobApplicationRepository
                .findJobApplicationByStatus(ApplicationStatus.NEW)
                .orElseThrow(() -> new RuntimeException("Newly applied candidates were not found"));

        for (JobApplication jobApply : listJobApply) {
            jobApply.setStatus(ApplicationStatus.In_REVIEW);
            jobApplicationRepository.save(jobApply);
            mailService.sendmail(jobApply.getEmail());
        }

    }

}
