package com.example.testkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView


class CustomAdapter (val context: Context, val DataList:ArrayList<Data>) : BaseAdapter()  {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        println("ssssssssssssssssssssssss_getView")

        /*custom_list를 activity_scroll_list에 맞게 변환하기 위해
        * view 라는 레이아웃을 임시로 만들어 놓고*/
        val view:View = LayoutInflater.from(context).inflate(R.layout.custom_list, null)

        /*xml에서 이미지뷰를 가져온다.*/
        val profile = view.findViewById<ImageView>(R.id.iv_custom)
        /*xml에서 텍스트뷰를 가져온다*/
        val name = view.findViewById<TextView>(R.id.tv_custom)
        /*하나의 데이터를 만드는데 DataList의 position부분*/
        val data = DataList[position]
        println("name.text: "+name.text)

        /*imageView의 이미지를 바꾸기위해*/
        profile.setImageResource(data.profile)
        println("data.profile: "+data.profile)
        name.text = data.name
        println("data.name: "+data.name)

        println("eeeeeeeeeeeeeeeeeeeeeeeee_getView")
        return view
    }
    //    override fun getCount(): Int = DataList.size
    override fun getCount(): Int {
        println("getCount")
        return DataList.size
    }

    //    override fun getItem(position: Int) = return DataList[position]
    override fun getItem(position: Int): Any {
        println("getItem: "+DataList[position])
        return DataList[position]
    }

    //    override fun getItemId(position: Int) = 0L
    override fun getItemId(position: Int): Long {
        println("getItemId")
        return 0L
    }





}