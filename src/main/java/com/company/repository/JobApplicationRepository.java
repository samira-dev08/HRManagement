package com.company.repository;

import com.company.entity.Attachment;
import com.company.entity.JobApplication;
import com.company.enums.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer> {

    @Query(value = "SELECT j.attachment FROM JobApplication j WHERE  j.jobPosting.id=?1")
    Optional<List<Attachment>> findAttachmentByJobPostingId(Integer jobPostingId);
    @Query(value = "SELECT j FROM JobApplication j WHERE  j.status=?1 ")
    Optional<List<JobApplication>> findJobApplicationByStatus(ApplicationStatus status);
}
