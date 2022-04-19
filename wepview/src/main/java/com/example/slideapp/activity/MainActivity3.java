package com.example.slideapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.slideapp.R;
import com.example.slideapp.activity.service.ILoginService;
import com.example.slideapp.vo.MemberVO;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity3 extends AppCompatActivity {

    private EditText editTextID, editTextPW;
    private Button btnLogin;
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("Ratrofit Login");

        setRetrofit();
        editTextID = findViewById(R.id.editText_id);
        editTextPW = findViewById(R.id.editText_pw);
        btnLogin = findViewById(R.id.btn_login);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });


    }

    private void setRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://localhost")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    private void login() {
        String id = editTextID.getText().toString();
        String pw = editTextPW.getText().toString();
        System.out.println("id : " +id);
        System.out.println("pw : " +pw);


        ILoginService service = retrofit.create(ILoginService.class);
        Call<MemberVO> call = service.getMemger(id, pw);

        call.enqueue(new Callback<MemberVO>() {
            @Override
            public void onResponse(Call<MemberVO> call, Response<MemberVO> response) {
                /*웹서버 응답 데이터가 들어옴*/
                MemberVO memberVO = response.body();

                if(memberVO != null){
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("memberVO", memberVO);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "회원이 아닙니다.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MemberVO> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "로그인에 실패하였습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
