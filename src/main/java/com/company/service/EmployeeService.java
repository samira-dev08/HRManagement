package com.company.service;

import com.company.dto.request.ReqEmployeeInfo;
import com.company.dto.response.RespEmployee;
import com.company.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee createEmployee(ReqEmployeeInfo employeeInfo);

   Employee getEmployeeById(Integer employeeId);

  List<RespEmployee> searchEmployee(String query);

}
