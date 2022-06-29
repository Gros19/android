package com.example.slideapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.slideapp.databinding.ActivityMain2Binding


class RadioB : AppCompatActivity() {
    val binding by lazy { ActivityMain2Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setContentView(binding.root)

        binding.radioGroup.setOnCheckedChangeListener{radioGroup, i ->
            when(i){
                R.id.radioButton1 -> println("1번")
                R.id.radioButton2 -> println("2번")
                R.id.radioButton3 -> println("3번")
            }

        }


        /*3번 디폴트 선택*/
        binding.radioGroup.check(R.id.radioButton2)
        /*모든 선택 해제*/
//        binding.radioGroup.clearCheck()




        /*onCreate함수 실행 시
        * 버튼 ID에 따라 출력*/
        /*when(binding.radioGroup.checkedRadioButtonId){
            R.id.radioButton1 -> println("1번")
            R.id.radioButton2 -> println("2번")
            R.id.radioButton3 -> println("3번")
        }*/
    }
}