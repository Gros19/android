package com.example.slideapp.activity.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {
    @POST("/p/test")
    Call<Post> createPost(@Body Post post);
}
