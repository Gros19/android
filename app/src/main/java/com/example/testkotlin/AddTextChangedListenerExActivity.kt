package com.example.testkotlin

import android.content.Intent
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.testkotlin.databinding.ActivityAddTextChangedListenerExBinding



class AddTextChangedListenerExActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAddTextChangedListenerExBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_text_changed_listener_ex)

//        iv_basic.setScaleType(ImageView.ScaleType.MATRIX)
        /*이미지 회전*/
//        val matrix = Matrix()
//        matrix.postRotate(30f)
//        iv_basic.setImageMatrix(matrix)



        /*필터 적용*/
//        binding = ActivityAddTextChangedListenerExBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        binding.ivBasic.setColorFilter(Color.parseColor("#ff0000"), PorterDuff.Mode.OVERLAY)


//        val iv : ImageView = findViewById(R.id.iv_basic)
//        iv.setColorFilter(Color.parseColor("#ff0000"), PorterDuff.Mode.MULTIPLY)

//        val myView : TextView = findViewById(R.id.et)
//        myView.addTextChangedListener(object: TextWatcher{
//            override fun afterTextChanged(p0 : Editable?){
//                println("입력 끝" +  p0)
//            }
//            override fun beforeTextChanged(p0: CharSequence?, p1:Int, p2:Int, p3:Int){
//                println("입력전" + p0)
//            }
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2:Int, p3:Int){
//                println("입력중" + p0)
//            }
//
//        })
    }

    fun Click(v:  View){
        binding = ActivityAddTextChangedListenerExBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.iv1.visibility = View.INVISIBLE
        binding.iv2.visibility = View.INVISIBLE
        binding.iv3.visibility = View.INVISIBLE
        println("Clicked ${v.id}")
        var a : View
        a = v
        when(v.id){
            binding.btn1.id -> binding.iv1.visibility = View.VISIBLE
            binding.btn2.id -> binding.iv2.visibility = View.VISIBLE
            binding.btn3.id -> binding.iv3.visibility = View.VISIBLE
        }
        println("음?")
    }

    fun LoadImage(view: View) {
        /*갤러리에서 사진을 선택하면*/
        startActivityForResult(Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI),0)

    }

        /*onActivityResult로 반환*/
        /*파라미터로 넘긴 requestCode: 0을 그대로 받고
        * */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        /*data가 null이 아닐때
        * 사진이 들어온 것이고*/
        /*setImageURI(널이 들어갈 수 있는 URI)
        * data? --> data가 널이 아니면 . 다음(.data)을 실행
        * URI로 변환
        * 선택한 이미지가 iv_basic에 출력된다.*/
//        binding = ActivityAddTextChangedListenerExBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        if(data != null) binding.ivBasic.setImageURI(data?.data)
    }
}

