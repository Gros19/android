package com.example.slideapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentStateAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa){
    var fragments = listOf<Fragment>()
//    프래그먼트 배열의 크기
    override fun getItemCount(): Int = fragments.size
//    반환될 프래그먼트
    override fun createFragment(position: Int): Fragment {
         return fragments.get(position)
    }

}