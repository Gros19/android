package com.example.testkotlin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class JavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);



        TextView textView=findViewById(R.id.tv_result);
        System.out.println("여기까지");
        textView.setText(String.format("%s님 환영합니다.",getIntent().getExtras().getString("etId")));

    }




}