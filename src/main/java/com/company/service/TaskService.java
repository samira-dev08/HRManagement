package com.company.service;

import com.company.dto.request.ReqTask;
import com.company.dto.response.RespTask;
import com.company.entity.Task;

import java.util.List;

public interface TaskService {
    Task createTask(Integer employeeId, Integer projectId, ReqTask reqTask);

    List<RespTask> getTask(Integer employeeId);
}
