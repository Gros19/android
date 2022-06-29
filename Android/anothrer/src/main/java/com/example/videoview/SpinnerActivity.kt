package com.example.videoview

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.videoview.databinding.ActivitySpinnerBinding

class SpinnerActivity : AppCompatActivity() {
    val binding by lazy {ActivitySpinnerBinding.inflate(layoutInflater)}
    val items = arrayOf("안녕", "하세", "요")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        /*현재 context에 클릭하면 내려오는 simple_spinner_dropdown_item과 위에서 선언한 items를 연결*/
        val myAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
        /*spinner의 adapter에 myAdapter을 달아준다*/
        binding.spinner.adapter = myAdapter
        binding.spinner.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                println("${p2} ${items[p2]}")
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                println("아무것도 선택 안함")
            }
        }
    }
}