package com.company.repository;

import com.company.entity.Payslip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PayslipRepository extends JpaRepository<Payslip,Integer> {
}
