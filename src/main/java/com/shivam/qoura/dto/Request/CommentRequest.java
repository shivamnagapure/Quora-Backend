package com.shivam.qoura.dto.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequest {
    private Long userId ;
    private String text ;
}
