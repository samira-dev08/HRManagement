package com.company.service.impl;

import com.company.dto.request.ReqProject;
import com.company.entity.Project;
import com.company.enums.ProjectStatus;
import com.company.mapper.ProjectMapper;
import com.company.repository.ProjectRepository;
import com.company.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
   private final ProjectRepository projectRepository;
   private final ProjectMapper projectMapper;

   @Override
   public Project createProject(ReqProject reqProject) {
      Project project=projectMapper.toProject(reqProject);
      project.setStatus(ProjectStatus.UPCOMING);
      return projectRepository.save(project);
   }

   @Override
   public Project getProjectById(Integer projectId) {
      return projectRepository.findById(projectId)
              .orElseThrow(() -> new RuntimeException("Not found Project"));
   }
}
