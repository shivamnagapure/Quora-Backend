package com.shivam.qoura.controller;

import com.shivam.qoura.adapters.UserRequestToUser;
import com.shivam.qoura.dto.Request.UserRequest;
import com.shivam.qoura.dto.Response.UserResponse;
import com.shivam.qoura.models.User;
import com.shivam.qoura.service.UserService;
import com.shivam.qoura.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    UserRequestToUser userRequestToUser ;

    UserService userService ;

    public  UserController(UserRequestToUser userRequestToUser , UserService userService ){
        this.userRequestToUser = userRequestToUser ;
        this.userService = userService ;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody  UserRequest userRequest){

        User user = userRequestToUser.convertToUser(userRequest);
        User createUser = userService.save(user);
        UserResponse response = Response.userResponse(createUser);
        return  ResponseEntity.status(HttpStatus.CREATED).body(response) ;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable Long userId){
        User findUser = userService.findUserById(userId);
        UserResponse response = Response.userResponse(findUser);
        return ResponseEntity.ok(response);
    }

}
