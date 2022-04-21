package com.example.slideapp.activity.retrofit;

import com.google.gson.annotations.SerializedName;

public class Post {
    public String getMem_mo() {
        return mem_mo;
    }

    public String getMem_id() {
        return mem_id;
    }

    public String getMem_pw() {
        return mem_pw;
    }

    public String getMem_name() {
        return mem_name;
    }

    @SerializedName("mem_mo")
    private String mem_mo;
    @SerializedName("mem_id")
    private String mem_id;
    @SerializedName("mem_pw")
    private String mem_pw;
    @SerializedName("mem_name")
    private String mem_name;

    public Post(String mem_mo, String mem_id, String mem_name, String mem_pw){
        this.mem_mo = mem_mo;
        this.mem_id = mem_pw;
        this.mem_name = mem_name;
        this.mem_pw = mem_pw;
    }



}
