package com.company.service.impl;

import com.company.dto.request.ReqPayroll;
import com.company.dto.response.RespPayslip;
import com.company.entity.Employee;
import com.company.entity.Payroll;
import com.company.entity.Payslip;
import com.company.enums.PayStatus;
import com.company.exception.PayrollException;
import com.company.mapper.PayrollMapper;
import com.company.repository.PayrollRepository;
import com.company.service.EmployeeService;
import com.company.service.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PayrollServiceImpl implements PayrollService {
    private static final Double HEALTINSURANCE_PERCENT = 15.0;
    private static final Double TAXES_PERCENT = 18.0;
    private final PayrollRepository payrollRepository;
    private final EmployeeService employeeService;
    private final PayrollMapper payrollMapper;

    @Override
    @Transactional
    public Payroll calculatePayroll(Integer employeeId, ReqPayroll reqPayroll) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        Payroll payroll = payrollMapper.toPayroll(reqPayroll);

        BigDecimal basicSalary = employee.getSalary();
        BigDecimal totalEarnings = basicSalary.add(reqPayroll.getBonuses()).add(reqPayroll.getOvertimePay());
        BigDecimal healthInsurance = totalEarnings.multiply(BigDecimal.valueOf(HEALTINSURANCE_PERCENT / 100));
        BigDecimal taxes = totalEarnings.multiply(BigDecimal.valueOf(TAXES_PERCENT / 100));
        BigDecimal totalDeductions = healthInsurance.add(taxes);
        BigDecimal netSalary = totalEarnings.subtract(totalDeductions);

        payroll.setEmployee(employee);
        payroll.setBasicSalary(basicSalary);
        payroll.setTaxes(taxes);
        payroll.setHealthInsurance(healthInsurance);
        payroll.setNetSalary(netSalary);
        if (netSalary.compareTo(BigDecimal.ZERO) > 0) {
            payroll.setPayStatus(PayStatus.PAID);
            payroll.setPayDate(LocalDate.now());
        } else {
            payroll.setPayStatus(PayStatus.UNPAID);
        }
        return payrollRepository.save(payroll);
    }

    @Override
    public List<RespPayslip> getPayslip(Integer employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);

        List<Payroll> payrollList = payrollRepository.getPayrollByEmployeeId(employeeId).get();
        if (payrollList.isEmpty()) {
            throw new PayrollException("Not found any payslip for this employee");
        }

        List<RespPayslip> payslipList = payrollList.stream()
                .map(payroll -> payrollMapper.toRespPayslip(payroll)).collect(Collectors.toList());
        for (RespPayslip payslip : payslipList) {
            payslip.setEmployeeName(employee.getFirstName());
            payslip.setEmployeeSurName(employee.getLastName());
            payslip.setGetEmployeeCode(employee.getEmployeeCode());
            payslip.setAccountNumber(UUID.randomUUID().toString());
        }
        return payslipList;
    }
}
