package com.example.testkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testkotlin.databinding.ActivityRecycleScrollBinding

private lateinit var binding: ActivityRecycleScrollBinding
class RecycleScrollActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_scroll)
        binding = ActivityRecycleScrollBinding.inflate(layoutInflater)
        val rootView : View = binding.root
        setContentView(rootView)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = RecycleAdapter()

    }
}