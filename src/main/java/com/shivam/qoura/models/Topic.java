package com.shivam.qoura.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.List;
import java.util.Set;

@Entity
public class Topic extends BaseModel{
    @Column(nullable = false)
    private String name ;

    @ManyToMany(mappedBy = "topics")
    List<Question> questions ;

}
