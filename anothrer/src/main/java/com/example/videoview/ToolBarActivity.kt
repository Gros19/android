package com.example.videoview

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.videoview.databinding.ActivityToolBarBinding

class ToolBarActivity : AppCompatActivity() {
    val binding by lazy { ActivityToolBarBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar2)
    }

     /*클릭을 하면 메뉴가 열림
     * 뷰형식으로 만들어
     * 띄움*/
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.share -> println("쉐어!")
            R.id.dduck -> println("뚝!")
        }
        return super.onOptionsItemSelected(item)
    }
}