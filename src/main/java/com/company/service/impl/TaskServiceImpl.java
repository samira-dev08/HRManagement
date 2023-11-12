package com.company.service.impl;

import com.company.dto.request.ReqTask;
import com.company.dto.response.RespTask;
import com.company.entity.Employee;
import com.company.entity.Project;
import com.company.entity.Task;
import com.company.enums.TaskStatus;
import com.company.mapper.TaskMapper;
import com.company.repository.TaskRepository;
import com.company.service.EmployeeService;
import com.company.service.ProjectService;
import com.company.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final EmployeeService employeeService;
    private final ProjectService projectService;
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public Task createTask(Integer employeeId, Integer projectId, ReqTask reqTask) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        Project project = projectService.getProjectById(projectId);
        Task task = taskMapper.toTask(reqTask);
        task.setEmployee(employee);
        task.setProject(project);
        task.setTaskStatus(TaskStatus.RUNNING);
        return taskRepository.save(task);
    }

    @Override
    public List<RespTask> getTask(Integer employeeId) {
        employeeService.getEmployeeById(employeeId);
        List<Task> taskList = taskRepository.findAllByEmployeeId(employeeId).get();
        if(taskList.isEmpty()){
            throw new RuntimeException("Not found for you any Task");
        }
         return taskList.stream()
                 .map(task -> taskMapper.toTaskResponse(task))
                 .collect(Collectors.toList());
    }
}
