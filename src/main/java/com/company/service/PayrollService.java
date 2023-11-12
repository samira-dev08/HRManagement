package com.company.service;

import com.company.dto.request.ReqPayroll;
import com.company.dto.response.RespPayslip;
import com.company.entity.Payroll;

import java.util.List;

public interface PayrollService{

    Payroll calculatePayroll(Integer employeeId,ReqPayroll reqPayroll);
    List<RespPayslip> getPayslip(Integer employeeId);
}
