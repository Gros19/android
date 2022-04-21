package com.example.slideapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.slideapp.R;
import com.example.slideapp.activity.retrofit.JsonPlaceHolderApi;
import com.example.slideapp.activity.retrofit.Post;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity3 extends AppCompatActivity {

    private EditText editTextID, editTextPW;
    private Button btnLogin;

    private JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("Ratrofit Login");


        editTextID = findViewById(R.id.editText_id);
        editTextPW = findViewById(R.id.editText_pw);
        btnLogin = findViewById(R.id.btn_login);


        // Retrofit 인스턴스 생성 (싱글톤 방식)
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://3.38.118.177:443")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        createPost();


    }

    private void createPost() {
        /*String mem_mo, String mem_id, String mem_name, String mem_pw*/
        Post post = new Post("11", "new id", "new name", "pwww");

        Call<Post> call = jsonPlaceHolderApi.createPost(post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()){
                    System.out.println("######################");
                    System.out.println("code : "+ response.code());
                    System.out.println("######################");
                    return;
                }
                Post postResponse = response.body();
                System.out.println("code: " + response.code());
                System.out.println("getMem_id: " + postResponse.getMem_id());
                System.out.println("getMem_name: " + postResponse.getMem_name());
                System.out.println("getMem_pw: " + postResponse.getMem_pw());
                System.out.println("getMem_mo: " + postResponse.getMem_mo());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                System.out.println(">>>>>>>>>>>>>>");
                System.out.println("error" + t.getMessage());
                System.out.println("<<<<<<<<<<<<<<");

            }
        });
    }


}
