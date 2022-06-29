package com.example.videoview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.videoview.databinding.ActivityTimeBinding

class TimeActivity : AppCompatActivity() {
    val binding by lazy{ActivityTimeBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.timePicker.hour
        binding.timePicker.minute
        binding.timePicker.setOnTimeChangedListener { timePicker, i, i2 ->
            println("$i :  $i2")
        }

        binding.timePicker2.hour
        binding.timePicker2.minute
        binding.timePicker2.setOnTimeChangedListener { timePicker, i, i2 ->
            println("###$i :  $i2")
        }
    }
}