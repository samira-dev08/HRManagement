package com.company.mapper;

import com.company.dto.request.ReqJobPosting;
import com.company.dto.response.RespJobPosting;
import com.company.entity.JobPosting;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobPostingMapper {
    JobPosting toJobPosting(ReqJobPosting reqJobPosting);
    RespJobPosting toJobPostingResponse(JobPosting jobPosting);
}
