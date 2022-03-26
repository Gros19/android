package com.example.testkotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testkotlin.databinding.CustomListBinding


class RecycleData(val profile:Int, val name:String)

class RecycleViewHolder(val binding: CustomListBinding) : RecyclerView.ViewHolder(binding.root){
    val profile = binding.ivCustom
    val name = binding.tvCustom
}

class RecycleAdapter(val RecycleDataList: ArrayList<RecycleData>) : RecyclerView.Adapter<RecycleViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        val binding = CustomListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecycleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return RecycleDataList.size
    }
    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        holder.profile.setImageResource(RecycleDataList[position].profile)
        holder.name.text = RecycleDataList[position].name
    }



}