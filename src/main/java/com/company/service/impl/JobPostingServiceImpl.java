package com.company.service.impl;

import com.company.dto.request.ReqJobPosting;
import com.company.dto.response.RespJobPosting;
import com.company.entity.Job;
import com.company.entity.JobPosting;
import com.company.mapper.JobPostingMapper;
import com.company.repository.JobPostingRepository;
import com.company.repository.JobRepository;
import com.company.service.JobPostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobPostingServiceImpl implements JobPostingService {
    private final JobPostingRepository jobPostingRepository;
    private final JobPostingMapper jobPostingMapper;
    private final JobRepository jobRepository;

    @Override
    public JobPosting createJobPost(Integer jobId, ReqJobPosting reqJobPosting) {
        JobPosting jobPosting = jobPostingMapper.toJobPosting(reqJobPosting);
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Not found this job! PLease create Job!"));
        jobPosting.setJobTitle(job);
        jobPosting.setActive(true);
        return jobPostingRepository.save(jobPosting);
    }

    @Override
    public void deleteJobPost(Integer jobPostId) {
        JobPosting jobPosting = jobPostingRepository.findById(jobPostId)
                .orElseThrow(() -> new RuntimeException("not found Job Post"));
        jobPosting.setActive(false);
        jobPostingRepository.save(jobPosting);
    }

    @Override
    public List<RespJobPosting> getAllActivePosts() {

        List<JobPosting> jobPostingList = jobPostingRepository.findAllByIsActive(true).
                orElseThrow(() -> new RuntimeException("not found active vacancy"));

        return jobPostingList.stream()
                .map(jobPosting -> jobPostingMapper.toJobPostingResponse(jobPosting))
                .collect(Collectors.toList());
    }

    @Override
    public JobPosting getJobPosting(Integer postingId) {
        return jobPostingRepository.findByIdAndIsActive(postingId)
                .orElseThrow(() -> new RuntimeException("not found active vacancy"));
    }
}
