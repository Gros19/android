package com.example.slideapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.slideapp.databinding.ActivityButtonGnactivityBinding

class ButtonGNActivity : AppCompatActivity() {

    val binding by lazy { ActivityButtonGnactivityBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.web
    }
    fun Load(v: View){
        when(v.id){}
        R.id.googleBt ->
    }
}