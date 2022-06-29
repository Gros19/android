package com.example.videoview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.videoview.databinding.ActivityAppBarBinding

class AppBarActivity : AppCompatActivity() {
    val binding by lazy{ ActivityAppBarBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.fab.setOnClickListener { println("클릭") }
    }
}