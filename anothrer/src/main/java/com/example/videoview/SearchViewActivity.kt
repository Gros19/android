package com.example.videoview

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.example.videoview.databinding.ActivitySearchViewBinding

class SearchViewActivity : AppCompatActivity() {
    val binding by lazy{ ActivitySearchViewBinding.inflate(layoutInflater)}
    var mydic = arrayOf("apple", "banana", "abc")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                println("${p0} 완료")
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                /*p0이 비어있지 않다면*/
                if(p0 != ""){
                    /*mydic 원소 하나하나가 x임*/
                        /*p0가 x에 포함이면 true curList에 저장*/
                    val curList = mydic.filter{x -> x.toLowerCase().contains(p0?.toLowerCase().toString())}
                    for(i in curList) println(i)
                    println("-------------")

                }
                return true
            }

        })
    }
}