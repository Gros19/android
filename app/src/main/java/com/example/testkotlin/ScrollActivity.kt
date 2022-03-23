package com.example.testkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.example.testkotlin.databinding.ActivityScrollListBinding

class ScrollActivity : AppCompatActivity() {

    private lateinit var binding : ActivityScrollListBinding

    var DataList = arrayListOf(
        Data(R.drawable.typescript,"0번"),
        Data(R.drawable.typescript,"1번"),
        Data(R.drawable.typescript,"2번"),
        Data(R.drawable.typescript,"3번")

    )
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_list)
        binding = ActivityScrollListBinding.inflate(layoutInflater)
        val rootview : View = binding.root
        setContentView(rootview)
/*
//        가로
//        setContentView(R.layout.activity_scroll)

//        세로
//        setContentView(R.layout.activity_scroll_horizontal)

//        가로세로
//        setContentView(R.layout.activity_scroll_all)*/

        println("시작")
        binding.listView.adapter = CustomAdapter(this, DataList)

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener{parent, view, position, id ->
            val selectItem = parent.getItemAtPosition(position) as Data
            Toast.makeText(this, selectItem.name, Toast.LENGTH_SHORT).show()
        }
        println("Rmx")


//        listToast()


    }

//    fun listToast(){
//        setContentView(R.layout.activity_scroll_list)
//        binding = ActivityScrollListBinding.inflate(layoutInflater)
//        val rootview : View = binding.root
//        setContentView(rootview)
//
//        val item = arrayOf("0번","1번","2번","3번","4번","5번","6번","7번","8번","9번","10번","11번","12번")
//        binding.listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, item)
//
//        binding.listView.onItemClickListener = AdapterView.OnItemClickListener{ parent, view, position, id ->
//            val selectItem = parent.getItemAtPosition(position)
//            println(selectItem)
//            println(selectItem.toString())
//            var st : String = selectItem.toString()
//            Toast.makeText(this, st, Toast.LENGTH_SHORT).show()
//        }
//    }
}