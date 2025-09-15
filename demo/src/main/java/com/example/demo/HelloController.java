package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String getHello() {
        return "Hello World" ;
    }

    @GetMapping("/")
    public Object homePage() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TodoInterface todo = retrofit.create(TodoInterface.class);

        Response<Todo> response = todo.getTodoById("4").execute();

        return response.body();
    }
}
