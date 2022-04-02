package com.example.slideapp

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.slideapp.databinding.ActivityButtonGnactivityBinding

class ButtonGNActivity : AppCompatActivity() {

    val binding by lazy { ActivityButtonGnactivityBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.webView.webViewClient = WebViewClient()

        Load(binding.googleBt)


    }

    fun Load(view: View) {
        when(view.id){
            R.id.googleBt -> binding.webView.loadUrl("https://www.google.com")
            R.id.naverBt -> binding.webView.loadUrl("https://m.naver.com")
        }

    }

}