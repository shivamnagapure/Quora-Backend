package com.shivam.qoura.adapters;

import com.shivam.qoura.dto.Request.UserRequest;
import com.shivam.qoura.models.User;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class UserRequestToUserImpl implements UserRequestToUser{


    @Override
    public User convertToUser(UserRequest userRequest) {

        return User.builder()
                .userName(userRequest.getUserName())
                .email(userRequest.getEmail())
                .bio(userRequest.getBio())
                .build();

    }
}
