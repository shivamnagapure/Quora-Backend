package com.shivam.qoura.dto.Request;


import com.shivam.qoura.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionRequest {

    private String title;
    private String body ;
    private Long userId ;
    private List<String> topics ;

}
