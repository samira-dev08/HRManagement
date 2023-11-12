package com.company.repository;

import com.company.entity.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll,Integer> {
    Optional<List<Payroll>> getPayrollByEmployeeId(Integer employeeId);
}
