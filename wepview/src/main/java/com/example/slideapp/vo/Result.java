package com.example.slideapp.vo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/*Parcelable - Activity로 파라미터를 넘기기 위해 사용*/
public class Result implements Parcelable {
    @SerializedName("mem_no")
    private String mem_mo;
    @SerializedName("mem_id")
    private String mem_id;
    @SerializedName("mem_pw")
    private String mem_pw;
    @SerializedName("mem_name")
    private String mem_name;

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

    public String getMem_mo() {
        return mem_mo;
    }

    public void setMem_mo(String mem_mo) {
        this.mem_mo = mem_mo;
    }

    public String getMem_id() {
        return mem_id;
    }

    public void setMem_id(String mem_id) {
        this.mem_id = mem_id;
    }

    public String getMem_pw() {
        return mem_pw;
    }

    public void setMem_pw(String mem_pw) {
        this.mem_pw = mem_pw;
    }

    public String getMem_name() {
        return mem_name;
    }

    public void setMem_name(String mem_name) {
        this.mem_name = mem_name;
    }



    public Result(String mem_id, String mem_pw){
        this.mem_id = mem_id;
        this.mem_pw = mem_pw;
    }


    protected Result(Parcel in) {
        mem_mo = in.readString();
        mem_id = in.readString();
        mem_pw = in.readString();
        mem_name = in.readString();
    }

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mem_mo);
        parcel.writeString(mem_id);
        parcel.writeString(mem_pw);
        parcel.writeString(mem_name);
    }
}
