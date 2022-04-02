package com.example.slideapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.slideapp.databinding.ActivityToggleBBinding

class ToggleB : AppCompatActivity() {
    private val binding by lazy {ActivityToggleBBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.toggleButton.setOnCheckedChangeListener{
            compoundButton, b->println(b)
        }
        /*디폴트 on*/
        binding.toggleButton.isChecked = true

    }
}