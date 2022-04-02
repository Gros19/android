package com.example.slideapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.slideapp.databinding.ActivityFloatingActionBBinding
import com.google.android.material.snackbar.Snackbar

class FloatingActionB : AppCompatActivity() {
    val binding by lazy { ActivityFloatingActionBBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.fab.setOnClickListener { View ->
//            버튼 누르면 "스낵바!" 라는 알림을 띄움
//            Snackbar.make(View, "스낵바!", Snackbar.LENGTH_LONG).show()
//            떠오른 스낵바에 클릭 버튼을 누르면 "하이"라는 단어가 출력됨
            Snackbar.make(View, "할말", Snackbar.LENGTH_LONG).setAction("클릭",{
                println("하이")
                binding.imageView.setImageResource(R.drawable.ic_baseline_person_24)
            }).show()
//            Snackbar.make(View, "할말", Snackbar.LENGTH_LONG).setAction("클릭",{View -> println("하이")}).show()
            binding.imageView.setImageResource(R.drawable.ic_baseline_favorite_24)
        }
    }
}