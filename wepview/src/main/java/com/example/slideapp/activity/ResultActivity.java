package com.example.slideapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.slideapp.R;
import com.example.slideapp.vo.Result;

public class ResultActivity extends AppCompatActivity {

    private TextView textView_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("Result");
        textView_result = findViewById(R.id.textView_result);

        /*로그인 시 넘겨받은 파라미터를 받는다.*/
        Intent intent = getIntent();
        Result result = intent.getParcelableExtra("memberVO");

        textView_result.setText(result.getMem_name() + "님 반갑");
    }
}