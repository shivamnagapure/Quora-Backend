package com.example.demo;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TodoInterface {

    @GET("posts/{id}")
    Call<Todo> getTodoById(@Path("id") String id);
}
