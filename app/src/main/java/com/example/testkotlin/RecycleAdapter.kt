package com.example.testkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class RecycleViewHolder(v: View) : RecyclerView.ViewHolder(v){}

class RecycleAdapter : RecyclerView.Adapter<RecycleViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        val cellForRow = LayoutInflater.from(parent.context).inflate(R.layout.custom_list, parent, false)
        return RecycleViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return 8;
    }
    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {

    }



}