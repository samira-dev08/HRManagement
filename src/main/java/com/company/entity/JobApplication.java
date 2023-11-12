package com.company.entity;

import com.company.enums.ApplicationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "applicant_fullname")
    private String applicantFullname;
    private String email;
    @ManyToOne
    @JoinColumn(name = "job_posting_id", referencedColumnName = "id")
    private JobPosting jobPosting;
    @OneToOne
    @JoinColumn(name="attachment_id",referencedColumnName = "id")
    private Attachment attachment;
    @Enumerated(value = EnumType.STRING)
    private ApplicationStatus status;

    public JobApplication( String email, JobPosting jobPosting, Attachment attachment, ApplicationStatus status) {
       // this.applicantFullname = applicantFullname;
        this.email = email;
        this.jobPosting = jobPosting;
        this.attachment = attachment;
        this.status = status;
    }
}
