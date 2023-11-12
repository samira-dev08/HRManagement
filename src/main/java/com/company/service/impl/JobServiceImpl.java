package com.company.service.impl;

import com.company.dto.request.ReqJob;
import com.company.entity.Job;
import com.company.repository.JobRepository;
import com.company.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;
    @Override
    public Job createJob(ReqJob reqJob) {
        return null;
    }

    @Override
    public Job getById(Integer jobId) {
        return jobRepository.findById(jobId).orElseThrow(() -> new RuntimeException("Job not found "));
    }
}
