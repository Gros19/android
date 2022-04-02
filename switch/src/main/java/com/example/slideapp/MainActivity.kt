package com.example.slideapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.slideapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        /*이미지 버튼*/
        binding.imageButton2.isClickable=true
        binding.imageButton2.setOnClickListener{println("star")}


        /*스위치*/
        binding.switch1.isChecked = true
        binding.switch1.setOnCheckedChangeListener{ componentButton, b ->
            println(b)
        }

        /*체크박스*/
        binding.checkBox1.setOnCheckedChangeListener{ compoundButton, b ->
            println(b)
            when(b){
                true -> {
                    binding.checkBox2.isChecked =true
                    binding.checkBox3.isChecked =true
                }
                false -> {
                    binding.checkBox2.isChecked = false
                    binding.checkBox3.isChecked =false
                }
            }


        }

    }

}


