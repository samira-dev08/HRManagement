package com.company.mapper;

import com.company.dto.request.ReqJob;
import com.company.entity.Job;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface JobMapper {
    Job toJob(ReqJob job);
}
