package com.shivam.qoura.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "topics")
public class Topic extends BaseModel{

    private Date createdAt ;

    @Column(nullable = false , unique = true)
    private String name ;

    @Column(name = "question_id")
    @ManyToMany(mappedBy = "topics")
    List<Question> questions ;

}
