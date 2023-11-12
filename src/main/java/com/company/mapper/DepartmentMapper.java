package com.company.mapper;

import com.company.dto.request.ReqDepartment;
import com.company.entity.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface DepartmentMapper {
    Department toDepartment(ReqDepartment department);
}
