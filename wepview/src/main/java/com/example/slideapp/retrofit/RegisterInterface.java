package com.example.slideapp.retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegisterInterface {
    String REGIST_URL = "";

    @FormUrlEncoded
    @POST("경로")
    Call<String> getUserRegist(
            @Field("name") String name,
            @Field("hobby") String hobby,
            @Field("username") String username,
            @Field("password") String password
    );
}
