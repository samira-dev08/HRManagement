package com.company.service;

import com.company.dto.request.ReqJobPosting;
import com.company.dto.response.RespJobPosting;
import com.company.entity.JobPosting;

import java.util.List;

public interface JobPostingService {
    JobPosting createJobPost(Integer jobId, ReqJobPosting reqJobPosting);

    void deleteJobPost(Integer jobPostId);

    List<RespJobPosting> getAllActivePosts();

    JobPosting getJobPosting(Integer postingId);
}
