package com.abhi.myntra.entity;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    private Date updatedDate;
    private String createdBy;
    private String updatedBy;
}
