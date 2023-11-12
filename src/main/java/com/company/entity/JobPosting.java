package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
public class JobPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "job_title_id",referencedColumnName = "id")
    private Job jobTitle;
    @Lob
    private String requirements;
    @Column(name="salary_range")
    private String salaryRange;

    private LocalDate deadline;
    @Column(name = "data_date")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDate;
    @Column(name="is_active")
    private boolean isActive;
}
