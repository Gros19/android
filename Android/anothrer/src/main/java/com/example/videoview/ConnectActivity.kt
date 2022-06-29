package com.example.videoview

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.videoview.databinding.ActivityConnectBinding

class ConnectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityConnectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button10.setOnClickListener {
            NetworkCheek(binding.button10)
        }






    }

    fun NetworkCheek(v: View){
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        println(connectivityManager.activeNetworkInfo?.isConnected)
    }
}