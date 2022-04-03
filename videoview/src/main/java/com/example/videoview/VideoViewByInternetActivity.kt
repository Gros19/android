package com.example.videoview

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import com.example.videoview.databinding.ActivityVideoViewByInternetBinding

class VideoViewByInternetActivity : AppCompatActivity() {
    val binding by lazy { ActivityVideoViewByInternetBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.videoView.setVideoURI(Uri.parse("https://cdn.videvo.net/videvo_files/video/free/2021-04/small_watermarked/210329_06B_Bali_1080p_005_preview.webm"))

        val mediaController = MediaController(this)
        binding.videoView.setMediaController(mediaController)
        binding.videoView.keepScreenOn = true



    }
}