package com.shivam.qoura.models;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;


/*@EntityListeners(AuditingEntityListener.class) : provide a mechanism to execute custom logic automatically at these predefined points in an entity's lifecycle,
which is particularly useful for tasks like auditing, logging, or enforcing business rules.For example,
they can be used to automatically set creation and modification timestamps on entities.*/

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = false , updatable = false)
    @CreatedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdAt ;

}
