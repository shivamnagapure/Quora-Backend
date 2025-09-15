package com.shivam.qoura.utils;

import com.shivam.qoura.dto.Response.UserResponse;
import com.shivam.qoura.models.User;
import org.springframework.stereotype.Component;

@Component
public class Response {

    public static UserResponse userResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .build();
    }
}
