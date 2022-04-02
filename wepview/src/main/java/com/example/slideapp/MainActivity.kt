package com.example.slideapp

import android.os.Bundle
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.slideapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    //lazy를 사용해서 처음 호출될 때 초기화 되도록 설정
    private lateinit var binding: ActivityMainBinding
    var lastTimeBackPressed = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*새로운 창을 방지하는 기능*/
        binding.webView.webViewClient = WebViewClient()

        binding.webView.loadUrl("https://www.google.com")
//        binding.webView.loadUrl("https://m.naver.com")

    }

    /*뒤로가기 버튼*/
    override fun onBackPressed() {
        if(binding.webView.canGoBack()) binding.webView.goBack()
        else {
            if(System.currentTimeMillis() - lastTimeBackPressed < 1500){
                finish()
                return
            }
            lastTimeBackPressed = System.currentTimeMillis()
            Toast.makeText(this, "'뒤로'버튼을 한 번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show()
        }
    }
}
