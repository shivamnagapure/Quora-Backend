package com.shivam.qoura.adapters;

import com.shivam.qoura.dto.Request.UserRequest;
import com.shivam.qoura.models.User;

public interface UserRequestToUser {

    User convertToUser(UserRequest userRequest);

}
