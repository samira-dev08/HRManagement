package com.company.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@DynamicInsert
public class Attachment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fileName;
    private String fileType;
    @Lob
    private byte[] data;
    @Column(name = "data_date")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDate;
    @ColumnDefault(value = "1")
    private Integer active;

    public Attachment(String fileName, String fileType, byte[] data){
        this.fileName=fileName;
        this.fileType=fileType;
        this.data=data;
    }

}
