package com.shivam.qoura.dto.Response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String userName ;
    private String email ;

    @JsonIgnore(value = true)
    private Date createdAt ;

    @JsonIgnore(value = true)
    private String bio ;
}
