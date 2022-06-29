package com.example.slideapp.activity

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.slideapp.R
import com.example.slideapp.databinding.ActivityButtonGnactivityBinding

class ButtonGNActivity : AppCompatActivity() {

    val binding by lazy { ActivityButtonGnactivityBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.webView.webViewClient = WebViewClient()
        binding.webView
//        Load(binding.googleBt)


        val tempHtml = "<html><body><h1>hello</h1>" +
                "<h1>안녕</h1><h2>만나서 방갑습니다.</h2><h3>오늘은 금요일입니다.</h3>" +
                "<p>웹뷰 사용법에 대해 알아보고 있습니다.</p>" +
                "</body></html>"

        binding.webView.loadData(tempHtml, "text/html", "UTF-8")

        binding.webView.loadDataWithBaseURL(null, tempHtml, "text/html", "utf-8", null)


    }

    fun load(view: View) {
        when(view.id){
            R.id.googleBt -> binding.webView.loadUrl("https://192.168.170.161:8443/melon/melon/getSingerSong")
            R.id.naverBt -> binding.webView.loadUrl("http://192.168.170.161:8070/melon/getSingerSong")
        }

    }

}