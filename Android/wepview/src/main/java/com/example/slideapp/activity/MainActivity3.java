package com.example.slideapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.slideapp.R;
import com.example.slideapp.retrofit.LoginInterface;
import com.example.slideapp.vo.PreferenceHelper;


import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity3 extends AppCompatActivity {

    private EditText editTextID, editTextPW;
    private Button btnLogin;
    private PreferenceHelper preferenceHelper;

    private final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("Ratrofit Login");


        preferenceHelper = new PreferenceHelper(this);
        btnLogin = findViewById(R.id.btn_login);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(this.getClass().getName() + "loginStart");
                loginUser();
            }
        });


//        Gson gson = new GsonBuilder().setLenient().create();
//
//        // Retrofit 인스턴스 생성 (싱글톤 방식)
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://gros19.click/")
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .build();
    }

    private void loginUser(){
        editTextID = findViewById(R.id.editText_id);
        editTextPW = findViewById(R.id.editText_pw);

        String username = editTextID.getText().toString().trim();
        String password = editTextPW.getText().toString().trim();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LoginInterface.LOGIN_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        LoginInterface api = retrofit.create(LoginInterface.class);
        Call<String> call = api.getUserLogin(username, password);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response)
            {
                if(response.isSuccessful() && response.body() != null)
                {
                    Log.e("onSuccess", response.body());

                    String jsonResponse = response.body();
//                    parseLoginData(jsonResponse);
                }
            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                Log.e(TAG,"에러 = " + t.getMessage());
            }
        });

    }
//
//    private void parseLoginData(String response) {
//        try{
//            JSONObject jsonObject = new JSONObject(response);
//        }
//    }


}
