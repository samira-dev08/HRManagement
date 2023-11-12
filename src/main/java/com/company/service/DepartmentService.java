package com.company.service;

import com.company.dto.request.ReqDepartment;
import com.company.entity.Department;

public interface DepartmentService {
    Department createDepartment(ReqDepartment reqDepartment);
}
