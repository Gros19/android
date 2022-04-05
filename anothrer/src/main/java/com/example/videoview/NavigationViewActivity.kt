package com.example.videoview

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.videoview.databinding.ActivityNavigationViewBinding
import com.google.android.material.navigation.NavigationView

class NavigationViewActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    val binding by lazy { ActivityNavigationViewBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button7.setOnClickListener { binding.layoutDrawer.openDrawer(GravityCompat.START)
        binding.naviVIew.setNavigationItemSelectedListener(this)}

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.access -> println("엑세스 클릭")
            R.id.email -> println("이메일 클릭")
            R.id.send -> println("보내기 클릭")
        }
        binding.layoutDrawer.closeDrawers()
        return false
    }

    override fun onBackPressed() {
        if(binding.layoutDrawer.isDrawerOpen(GravityCompat.START)) binding.layoutDrawer.closeDrawers()
        else super.onBackPressed()
    }
}