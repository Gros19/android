package com.example.videoview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.videoview.databinding.ActivityRatingBarBinding

class RatingBarActivity : AppCompatActivity() {
    val binding by lazy{ ActivityRatingBarBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        /*fl은 float형*/
        binding.ratingBar.setOnRatingBarChangeListener { ratingBar, fl, b ->
            println(fl)
        }
        binding.ratingBar.rating = 1.5f
    }
}