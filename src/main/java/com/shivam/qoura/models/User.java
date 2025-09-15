package com.shivam.qoura.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User extends BaseModel{
    @Column(nullable = false)
    private String userName ;

    @Email
    @NotBlank// works at application layer (in controller layer , userRequest.email is null )
    @Column(nullable = false , unique = true) // works at database layer
    private String email ;

    private String bio ;


}
