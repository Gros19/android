package com.example.slideapp.activity.service;

import com.example.slideapp.vo.MemberVO;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ILoginService {
    @POST("/p/test")
    Call<MemberVO> getMemger(
            @Query("mem_id")  String mem_id,
            @Query("mem_pw") String mem_pw);

}
