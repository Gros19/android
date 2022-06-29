package com.example.slideapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import com.example.slideapp.vo.PreferenceHelper
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.slideapp.R
import retrofit2.Retrofit
import com.example.slideapp.retrofit.LoginInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.scalars.ScalarsConverterFactory

class MainActivity3 : AppCompatActivity() {
    private var editTextID: EditText? = null
    private var editTextPW: EditText? = null
    private var btnLogin: Button? = null
    private var preferenceHelper: PreferenceHelper? = null
    private val TAG = "LoginActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        title = "Ratrofit Login"
        preferenceHelper = PreferenceHelper(this)
        btnLogin = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                println(this.javaClass.name + "loginStart")
                loginUser()
            }
        })


//        Gson gson = new GsonBuilder().setLenient().create();
//
//        // Retrofit 인스턴스 생성 (싱글톤 방식)
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://gros19.click/")
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .build();
    }

    private fun loginUser() {
        editTextID = findViewById(R.id.editText_id)
        editTextPW = findViewById(R.id.editText_pw)
        val username = editTextID.getText().toString().trim { it <= ' ' }
        val password = editTextPW.getText().toString().trim { it <= ' ' }
        val retrofit = Retrofit.Builder()
            .baseUrl(LoginInterface.LOGIN_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
        val api = retrofit.create(LoginInterface::class.java)
        val call = api.getUserLogin(username, password)
        call.enqueue(object : Callback<String?> {
            override fun onResponse(call: Call<String?>, response: Response<String?>) {
                if (response.isSuccessful && response.body() != null) {
                    Log.e("onSuccess", response.body()!!)
                    val jsonResponse = response.body()
                    //                    parseLoginData(jsonResponse);
                }
            }

            override fun onFailure(call: Call<String?>, t: Throwable) {
                Log.e(TAG, "에러 = " + t.message)
            }
        })
    } //
    //    private void parseLoginData(String response) {
    //        try{
    //            JSONObject jsonObject = new JSONObject(response);
    //        }
    //    }
}