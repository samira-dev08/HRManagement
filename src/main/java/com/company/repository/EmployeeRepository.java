package com.company.repository;

import com.company.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    @Query("SELECT e FROM Employee e WHERE " +                      //jpql
            "e.firstName LIKE CONCAT ('%',:query,'%')" +
            "Or e.lastName LIKE CONCAT('%',:query,'%')"+
            "Or e.gender LIKE CONCAT('%',:query,'%')"+
            "Or e.position.jobTitle LIKE CONCAT('%',:query,'%')"
           )
    Optional<List<Employee>> searchEmployees(String query);



}
