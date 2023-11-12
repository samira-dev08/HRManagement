package com.company.entity;

import com.company.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;
    @OneToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;
    @Lob
    private String note;
    @Column(name="approximate_start_date")
    private LocalDate approximateStartDate;
    @Column(name="approximate_end_date")
    private LocalDate approximateEndDate;
    @Enumerated(value = EnumType.STRING)
    @Column(name="task_status")
    private TaskStatus taskStatus;


}
