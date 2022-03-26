package com.example.testkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager


import com.example.testkotlin.databinding.ActivityRecycleScrollBinding
var RecycleDataList = arrayListOf(
    RecycleData(R.drawable.typescript,"0번"),
    RecycleData(R.drawable.typescript,"1번"),
    RecycleData(R.drawable.typescript,"2번"),
    RecycleData(R.drawable.typescript,"3번"),
    RecycleData(R.drawable.typescript,"4번"),
    RecycleData(R.drawable.typescript,"5번"),
    RecycleData(R.drawable.typescript,"6번"),
    RecycleData(R.drawable.typescript,"7번"),
    RecycleData(R.drawable.typescript,"8번"),
    RecycleData(R.drawable.typescript,"9번"),
    RecycleData(R.drawable.typescript,"10번"),
    RecycleData(R.drawable.typescript,"11번"),
    RecycleData(R.drawable.typescript,"12번"),
    RecycleData(R.drawable.typescript,"13번")
)
private lateinit var binding: ActivityRecycleScrollBinding
class RecycleScrollActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_scroll)
        binding = ActivityRecycleScrollBinding.inflate(layoutInflater)
        val rootView : View = binding.root
        setContentView(rootView)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = RecycleAdapter(RecycleDataList)

    }

}