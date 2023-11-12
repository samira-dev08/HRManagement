package com.company.mapper;

import com.company.dto.request.ReqEmployee;
import com.company.dto.response.RespEmployee;
import com.company.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee toEmployee(ReqEmployee reqEmployee);
    RespEmployee toEmloyeeResponse(Employee employee);
}
