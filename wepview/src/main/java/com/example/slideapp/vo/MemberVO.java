package com.example.slideapp.vo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/*Parcelable - Activity로 파라미터를 넘기기 위해 사용*/
public class MemberVO implements Parcelable {
    @SerializedName("mem_no")
    private String mem_mo;
    @SerializedName("mem_id")
    private String mem_id;
    @SerializedName("mem_pw")
    private String mem_pw;
    @SerializedName("mem_name")
    private String mem_name;

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



    public MemberVO(String mem_id, String mem_pw){
        this.mem_id = mem_id;
        this.mem_pw = mem_pw;
    }


    protected MemberVO(Parcel in) {
        mem_mo = in.readString();
        mem_id = in.readString();
        mem_pw = in.readString();
        mem_name = in.readString();
    }

    public static final Creator<MemberVO> CREATOR = new Creator<MemberVO>() {
        @Override
        public MemberVO createFromParcel(Parcel in) {
            return new MemberVO(in);
        }

        @Override
        public MemberVO[] newArray(int size) {
            return new MemberVO[size];
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
