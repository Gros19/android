package com.example.videoview

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.videoview.databinding.ActivityMainBinding
import java.util.*
import kotlin.concurrent.schedule
import kotlin.concurrent.timer

class PrograssBarActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    var timer : Timer? = null
    /*var timer: TimerTask? = null*/
    var daltaTime = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.startBt.setOnClickListener{
            TimerFun()
            daltaTime = 0
        }
        binding.stopBt.setOnClickListener { timer?.cancel() }

        Timer().schedule(2000){ println("2초가 지남")}
        Timer().schedule(2000, 100){
            println("2초 후")
            /*강제종료*/
//            binding.startBt.text = "시작버튼!!"
            /*솔루션*/
            runOnUiThread{
                binding.startBt.text = "시작버튼!!"
            }

        }
        Handler().postDelayed({ println("5초가 지남")}, 5000)


    }

    private fun TimerFun() {
        /*0.1초마다 계속 반복*/
        timer = timer(period = 100, initialDelay = 2000){
            /*timer = Timer().schedul(1000, 100)*/
            /*daltaTime이 0~ 99까지 증가되고 100이되면 반복 종료*/
            if(daltaTime > 100) cancel()
            /*진행상황 세팅*/
            binding.progressBar2.setProgress(++daltaTime)
            println(binding.progressBar2.progress)

            /*타이머가 계속 돌고있기 때문에
            * ui 변경 시 강제종료
            * runOnUiThread가 안전하게 Ui를 변경시켜 줌*/
            runOnUiThread {binding.startBt.text = "dd"}
        }
    }
}