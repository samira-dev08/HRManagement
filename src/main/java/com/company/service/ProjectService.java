package com.company.service;

import com.company.dto.request.ReqProject;
import com.company.entity.Project;

public interface ProjectService {
    Project createProject(ReqProject reqProject);

    Project getProjectById(Integer projectId);
}
