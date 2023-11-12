package com.company.repository;

import com.company.entity.Employee;
import com.company.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {

    Optional<List<Task>> findAllByEmployeeId(Integer employeeId);
}
