package com.company.service.impl;

import com.company.dto.request.ReqEmployeeInfo;
import com.company.dto.response.RespEmployee;
import com.company.entity.Address;
import com.company.entity.Contact;
import com.company.entity.Employee;
import com.company.entity.Job;
import com.company.mapper.EmployeeMapper;
import com.company.repository.EmployeeRepository;
import com.company.service.AddressService;
import com.company.service.ContactService;
import com.company.service.EmployeeService;
import com.company.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final AddressService addressService;
   private final ContactService contactService;
   private final JobService jobService;


    @Override
    public Employee createEmployee(ReqEmployeeInfo employeeInfo) {
        Address address=addressService.addAddress(employeeInfo.getReqAddress());
        Contact contact=contactService.addContact(employeeInfo.getReqContact());
        Employee employee = employeeMapper.toEmployee(employeeInfo.getReqEmployee());

        Integer jobId=employeeInfo.getReqEmployee().getJobId();
        Job job=jobService.getById(jobId);
        employee.setAddress(address);
        employee.setContact(contact);
        employee.setPosition(job);
        employee.setEmployeeCode(UUID.randomUUID().toString());
        employee.setActive(true);
        return  employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Integer employeeId) {
        Employee employee= employeeRepository.findById(employeeId)
                 .orElseThrow(() -> new RuntimeException("not found this employee"));
        return employee;

    }

    @Override
    public List<RespEmployee> searchEmployee(String query) {
        List<Employee> employeeList=employeeRepository.searchEmployees(query).
                orElseThrow(() -> new RuntimeException("Not found any Info for this search"));
        return employeeList.stream().
                map(employee -> employeeMapper.toEmloyeeResponse(employee))
                .collect(Collectors.toList());
    }
}
