package com.shivam.qoura.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@Entity
public class Topic extends BaseModel{

    private Date createdAt ;

    @Column(nullable = false , unique = true)
    private String name ;

    @ManyToMany(mappedBy = "topics")
    List<Question> questions ;

}
