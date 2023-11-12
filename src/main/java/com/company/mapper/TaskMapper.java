package com.company.mapper;

import com.company.dto.request.ReqTask;
import com.company.dto.response.RespTask;
import com.company.entity.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    Task toTask(ReqTask reqTask);

    RespTask toTaskResponse(Task task);
}
