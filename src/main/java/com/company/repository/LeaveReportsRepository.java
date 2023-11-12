package com.company.repository;

import com.company.entity.Employee;
import com.company.entity.LeaveReports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeaveReportsRepository extends JpaRepository<LeaveReports,Integer> {
    Optional<List<LeaveReports>> findByEmployeeId(Integer employeeId);
    @Query(value = "SELECT * FROM leave_reports  WHERE " +                      //jpql
            "employee_id LIKE CONCAT ('%',:query,'%')"
            +"Or leave_status LIKE CONCAT('%',:query,'%')", nativeQuery = true
    )
   Optional<List<LeaveReports> > searchLeaveReports(String query);

}
