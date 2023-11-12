package com.company.mapper;

import com.company.dto.request.ReqPayroll;
import com.company.dto.response.RespPayslip;
import com.company.entity.Payroll;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PayrollMapper {

    Payroll toPayroll(ReqPayroll reqPayroll);

    RespPayslip toRespPayslip(Payroll payroll);
}
