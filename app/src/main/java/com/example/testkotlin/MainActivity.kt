package com.example.testkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.testkotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    val a : Int = 2
    var b = 2 //가능

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun DDuck(v : View){
            println("뚝!!")
        }
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.dd.setOnClickListener{
            DDuck(it)
        }
//        //바인딩 초기화
//        val binding = ActivityMainBinding.inflate(layoutInflater)
//        //레이아웃(root뷰) 표시
//        setContentView(binding.root)
//        //뷰바인딩으로 버튼 접근
//        binding.btn.setOnClickListener{
//            //뷰바인딩으로 텍스트 접근
//            binding.btn.text = " 바인딩 굳"
//            Toast.makeText(this, "토스트",Toast.LENGTH_SHORT).show()
//        }


        val items : List<String> = listOf("apple", "bannana", "kiwifruit")
        for(index in items.indices){
            println("for문: $index   ${items[index]}")
        }

        var index = 0
        while(index < items.size){
            println("while문: ${index} ${items[index++]}")
        }

//        의도적으로 무한루프를 발생
//        앱이 강제로 꺼지지는 않았다
//        while(true)println("좋아")

        fun describe(obj: Any): String =
            when (obj){
                1       ->  "One"
                "Hello" ->  "Greeting"
                is Long ->  "Long"
                !is String->    "Not a string"
                else    ->  "Unknown"
            }

        val x = 10
        val y = 9
        if( x >= 1 && x <= y+1){
            println("범위 안")
        }
        if(x in 1..y+1){
            println("범위 안")
        }

        val list : List<String> = listOf("a", "b", "c")


        if (-1 !in 0..list.lastIndex){
            println("-1은 범위 안에 없다.")
        }
        if (list.size !in list.indices){
            println("리스트 인덱스를 넘어갔다.")
            println("list.indices: ${list.indices}")
        }

        for( x in 1..5){
            println(x)
        }


        for (x in 1..10 step 2) println(x)
        println("개행")
        for(x in 9 downTo 0 step 3)println(x)


        val items2 : Set<String> = setOf("apple", " banana", "kiwifruit")
        when{
            "orange" in items2 -> println("juicy")
            "apple" in items2 -> println("apple is fine too")
        }

        val fruits : List<String> = listOf("banana", "avocado", "apple", "kiwifruit")
        fruits
            .filter{it.startsWith("a")}
            .sortedBy{it}
            .map{it.toUpperCase() }
            .forEach{println(it)}

//        println(describe(1))
//        println(describe("Hello"))
//        println(describe(1L))
//        println(describe(1f))
//        println(describe("뚝"))


//        val str :String = "코로나 조심하세요"
//        val str2 = "${ str.replace("조심하세요", "이겨내요") }!!"+ "$$$!!!"
//        println(str2)
//        println(getStringLength("누구인가? 누가 기침소리를 내었는가?"))
//        b -= 1

//        a = 1
//        a = 2 //에러 val a 는 변경 불가
//        b = 1
//        b = 2 //가능 var은 기존 변수처럼 사용
        /*println("안녕하세요")
        println("Gros19예요")
        sum(3,4)*/

//        println(maxOfLift(3, 4))
//        println(parseInt("100"))
//        println(parseInt("호밀밭의"))
    }
    fun getStringLength(obj: Any): Int?{
        if( obj is String) {
            //여기서는 obj가 String
            return obj.length
        }
        return null
    }

    fun parseInt(str: String): Int?{ // Int? 리턴 Int형인데 null 가능
        var myNum : Int? = null
        try{ myNum = str.toInt()}
        catch(nfe : NumberFormatException){
            return null
        }
        return myNum
    }

    fun maxOfLift(a: Int, b: Int): Int{
        return if(a > b){
            a
        }else {
            b
        }
    }

    fun maxOf(a: Int, b: Int): Int{
        if(a > b){
            return a
        }else {
            return b
        }
    }

    fun maxOfMinimum(a: Int, b: Int) = if(a > b) a else b


//    fun sum(a: Int, b: Int){
//        println("$a 과 $b 의 합은 ${a+b}")
//    }

//    fun sum(a: Int, b: Int): Unit{
//        println(sum(1,2f))
//    }

//    println(sum(1, 2 f))
//    fun sum(a: Int, b: Float) = a + b

}