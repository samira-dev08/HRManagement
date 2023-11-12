package com.company.service;

import com.company.dto.request.ReqJob;
import com.company.entity.Job;

public interface JobService {
    Job createJob(ReqJob reqJob);
    Job getById(Integer jobId);
}
