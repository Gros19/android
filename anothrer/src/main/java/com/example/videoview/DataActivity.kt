package com.example.videoview

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        val pref = getSharedPreferences("pref", Context.MODE_PRIVATE)
        /*저장*/
        pref.edit().putString("키", "값").apply()
        /*불러오기*/
        val value = pref.getString("키", "저장안됨")
        println(value)
        /*키 제거*/
        pref.edit().remove("키").apply()
        /*전체제거*/
        pref.edit().clear().apply()
    }
}