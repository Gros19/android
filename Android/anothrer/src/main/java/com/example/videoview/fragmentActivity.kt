package com.example.videoview

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.videoview.databinding.ActivityFragmentBinding
import render.animations.Bounce
import render.animations.Render


class fragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFragmentBinding.inflate(layoutInflater)

        setContentView(binding.root)

        /*Create Render Class*/
        val render = Render(this)
        /*set Animation*/


        binding.button111.setOnClickListener {
            render.setAnimation(Bounce().InDown(binding.button111))
            render.start()
            println("1번")
            binding.framLayout.removeAllViewsInLayout()
            supportFragmentManager.beginTransaction().replace(R.id.framLayout, OneFragment()).commit()
        }
        binding.button22.setOnClickListener {
            render.setAnimation(Bounce().InDown(binding.button22))
            render.start()
            println("2번")
            binding.framLayout.removeAllViewsInLayout()
            supportFragmentManager.beginTransaction().replace(R.id.framLayout, TwoFragment()).commit()
        }


        binding.f3btn.setOnClickListener {
            var ad = AlertDialog.Builder(this)
            ad.setIcon(R.mipmap.ic_launcher)
            ad.setTitle("제목")
            ad.setMessage("내용")
            ad.setView(EditText(this))
            ad.setPositiveButton("네", object:DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    println("네 클릭")
                    p0?.dismiss()

                    var intent = Intent()
                    intent.setAction(Intent.ACTION_SEND)
                    intent.setType("text/plain")
                    intent.putExtra(Intent.EXTRA_SUBJECT, title)
                    intent.putExtra(Intent.EXTRA_TEXT, "내용")
                    startActivity(Intent.createChooser(intent, "공유"))
                }
            })

            ad.setNegativeButton("아니오", object:DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    println("아니오 클릭")
                    p0?.dismiss()
                }
            })

            ad.show()
        }

    }
}


class OneFragment: Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.frag1, container, false) //fragment를 view형식으로 반환
}

class TwoFragment: Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.frag2, container, false) //fragment를 view형식으로 반환

}