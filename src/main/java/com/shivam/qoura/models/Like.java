package com.shivam.qoura.models;

import jakarta.persistence.*;

@Entity
@Table(name = "likes" , uniqueConstraints = @UniqueConstraint(columnNames = {"user_id" , "target_type" , "target_id"}))
public class Like  extends BaseModel{

    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private User user ;

    @Enumerated(EnumType.STRING)
    private TargetType  targetType ;

    private Long targetId ;

}
