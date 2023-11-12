package com.company.mapper;

import com.company.dto.request.ReqProject;
import com.company.entity.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    Project toProject(ReqProject reqProject);

}
