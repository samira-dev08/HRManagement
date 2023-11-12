package com.company.repository;

import com.company.entity.Job;
import com.company.entity.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting,Integer> {
//    @Query(value = "SELECT j FROM JobPosting j WHERE j.isActive = true")
    Optional<List<JobPosting> > findAllByIsActive(Boolean active);
    @Query(value = "SELECT j FROM JobPosting j WHERE  j.id=?1 and j.isActive = true")
    Optional<JobPosting> findByIdAndIsActive(Integer id);
}
