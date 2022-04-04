package com.example.videoview

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.videoview.databinding.ActivitySeekBarBinding

class SeekBarActivity : AppCompatActivity() {
    val binding by lazy { ActivitySeekBarBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.seekBar.progress = 22

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                println(p1)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                println("움직이기 시작")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                println("움직이기 끝")
            }

        })
    }
}