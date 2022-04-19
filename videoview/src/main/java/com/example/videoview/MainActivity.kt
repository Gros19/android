package com.example.videoview

import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import com.example.videoview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val videoPath = "android.resource://" + packageName + "/" /*+ R.raw.a*/
        /*리소스파일에 있는 mp4를 videoView에 바인딩*/
        binding.videoView.setVideoPath(videoPath)

        val mediaController = MediaController(this)
        binding.videoView.setMediaController(mediaController)
        /*동영상 비율을 일정하게 하기 위해 주석처리*/
//        mediaController.setAnchorView(binding.videoView)
        binding.videoView.keepScreenOn = true

        /*시작*/
        binding.videoView.start()

        /*일시정지*/
        binding.videoView.pause()

        /*10초로 이동 */
        binding.videoView.seekTo(10000)
//        /*준비되면 바로 시작*/
//        binding.videoView.setOnPreparedListener{
//            Toast.makeText(this, "준비 완료", Toast.LENGTH_SHORT).show()
//            binding.videoView.start()
//        }


    }
}