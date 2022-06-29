package com.example.testkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.testkotlin.databinding.CustomListBinding


class RecycleData(val profile:Int, val name:String)

class RecycleViewHolder(val binding: CustomListBinding) : RecyclerView.ViewHolder(binding.root){
    val profile = binding.ivCustom
    val name = binding.tvCustom
}
//class RecycleAdapter(val RecycleDataList: ArrayList<RecycleData>) : RecyclerView.Adapter<RecycleViewHolder>(){
class RecycleAdapter(val RecycleDataList: ArrayList<RecycleData>, val context : Context) : RecyclerView.Adapter<RecycleViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
//        val binding = CustomListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val binding = CustomListBinding.inflate(LayoutInflater.from(context), parent, false)
        return RecycleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return RecycleDataList.size
    }
    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        /*축약 가능*/
        val curData = RecycleDataList[position]
        holder.profile.setImageResource(curData.profile)
        holder.name.text = curData.name

        /*item click 시  text 출력*/
        holder.itemView.setOnClickListener{
//            v ->  Toast.makeText(v.context, RecycleDataList[position].name, Toast.LENGTH_SHORT).show()
            (context as RecycleScrollActivity).RecyclerClick(curData)
        }

    }



}