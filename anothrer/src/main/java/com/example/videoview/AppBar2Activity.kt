package com.example.videoview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.videoview.databinding.ActivityAppBar2Binding
import com.google.android.material.tabs.TabLayout

class AppBar2Activity : AppCompatActivity() {
    val binding by lazy { ActivityAppBar2Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.tabs.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                println("selected! ${tab?.position}")
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                println("선택 안 됌")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                println("다시 선택")
            }
        })
    }
}