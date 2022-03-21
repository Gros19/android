package com.example.testkotlin

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.testkotlin.databinding.ActivityJavaBinding
import com.example.testkotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
//    val a : Int = 2
//    var b = 2 //가능

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var pref = this.getPreferences(0)
        binding.etEmail.setText(pref.getString("이메일",""))
        binding.etId.setText(pref.getString("아이디",""))
        binding.etPass.setText(pref.getString("비밀번호",""))
        binding.etAge.setText(pref.getString("나이",""))
        binding.etName.setText(pref.getString("이름",""))




        /*마지막 EditText 완료버튼은 Login호출*/
        binding.etPass.setOnEditorActionListener{v, actionId, event ->
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    println(actionId)
                    Login(v)
                    true
                }else false
            }
    }
    fun Adenticate(): Boolean{
        return binding.etEmail.text.toString() == "asdf@gmail.com" &&
                binding.etAge.text.toString() == "32" &&
                binding.etName.text.toString() == "Kim" &&
                binding.etId.text.toString() == "kkk" &&
                binding.etPass.text.toString() == "asdf"
    }

    fun Login(view: View) {
        /*키보드 숨기기*/
        var imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

        /*입력정보 비교*/
        var  msg : String = ""
        if(Adenticate()){
            msg="로그인 성공"
            println("로그인 성공")
            /*엑티비티 이동*/
            val nextIntent = Intent(this, JavaActivity::class.java)
            nextIntent.putExtra("etId", binding.etId.text.toString())
            startActivity(nextIntent)

            /*엑티비티 이동 방법2*/
            /*setContentView(R.layout.activity_java)
            val textView: TextView =findViewById(R.id.tv_result)
            textView.setText("${binding.etId.text}님 환영합니다.")*/


            /*로그인 정보 저장*/
            var editor = this.getPreferences(0).edit()
            editor.putString("이메일",binding.etEmail.text.toString()).apply()
            editor.putString("비밀번호",binding.etPass.text.toString()).apply()
            editor.putString("이름",binding.etName.text.toString()).apply()
            editor.putString("나이",binding.etAge.text.toString()).apply()
            editor.putString("아이디",binding.etId.text.toString()).apply()




        }else{
            msg="로그인 실패"
            println("로그인 실패")
        }
        println("${binding.etEmail.text} ${binding.etAge.text} ${binding.etName.text} ${binding.etPass.text} ${binding.etId.text}")

        var t = Toast.makeText(this, msg,Toast.LENGTH_LONG)
        t.setGravity(Gravity.TOP, 0, 0)
        t.show()
    }
}


//        val loginVinding = ActivityMainBinding.inflate(layoutInflater)
//        loginVinding.loginBtn.setOnClickListener {
//            println("일단 여기까지")
//            loginVinding.etPass.setOnEditorActionListener{v, actionId, event ->
//                if(actionId == EditorInfo.IME_ACTION_DONE){
//                    login(v)
//                    true
//                }else false
//            }
//        }










//        fun DDuck(v : View){
//            println("뚝!!")
//        }
//        val binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        var cnt = 0;
//        binding.dd.setOnClickListener{
//            DDuck(it)
//            binding.dd.text = "${cnt++}"
//        }
//
//
//
//        binding.visibleBtOn.setOnClickListener {
////            binding.visibleBT.isVisible = true
//            binding.visibleBT.visibility = View.VISIBLE
//            binding.emilLink.isEnabled = true
//        }
//        binding.visibleBT.setOnClickListener {
////            binding.visibleBT.isVisible=false
//            binding.visibleBT.visibility = View.INVISIBLE
//
//
//        }
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


//        val items : List<String> = listOf("apple", "bannana", "kiwifruit")
//        for(index in items.indices){
//            println("for문: $index   ${items[index]}")
//        }
//
//        var index = 0
//        while(index < items.size){
//            println("while문: ${index} ${items[index++]}")
//        }

//        의도적으로 무한루프를 발생
//        앱이 강제로 꺼지지는 않았다
//        while(true)println("좋아")

//        fun describe(obj: Any): String =
//            when (obj){
//                1       ->  "One"
//                "Hello" ->  "Greeting"
//                is Long ->  "Long"
//                !is String->    "Not a string"
//                else    ->  "Unknown"
//            }
//
//        val x = 10
//        val y = 9
//        if( x >= 1 && x <= y+1){
//            println("범위 안")
//        }
//        if(x in 1..y+1){
//            println("범위 안")
//        }
//
//        val list : List<String> = listOf("a", "b", "c")
//
//
//        if (-1 !in 0..list.lastIndex){
//            println("-1은 범위 안에 없다.")
//        }
//        if (list.size !in list.indices){
//            println("리스트 인덱스를 넘어갔다.")
//            println("list.indices: ${list.indices}")
//        }
//
//        for( x in 1..5){
//            println(x)
//        }
//
//
//        for (x in 1..10 step 2) println(x)
//        println("개행")
//        for(x in 9 downTo 0 step 3)println(x)
//
//
//        val items2 : Set<String> = setOf("apple", " banana", "kiwifruit")
//        when{
//            "orange" in items2 -> println("juicy")
//            "apple" in items2 -> println("apple is fine too")
//        }
//
//        val fruits : List<String> = listOf("banana", "avocado", "apple", "kiwifruit")
//        fruits
//            .filter{it.startsWith("a")}
//            .sortedBy{it}
//            .map{it.toUpperCase() }
//            .forEach{println(it)}

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

//    fun getStringLength(obj: Any): Int?{
//        if( obj is String) {
//            //여기서는 obj가 String
//            return obj.length
//        }
//        return null
//    }
//
//    fun parseInt(str: String): Int?{ // Int? 리턴 Int형인데 null 가능
//        var myNum : Int? = null
//        try{ myNum = str.toInt()}
//        catch(nfe : NumberFormatException){
//            return null
//        }
//        return myNum
//    }
//
//    fun maxOfLift(a: Int, b: Int): Int{
//        return if(a > b){
//            a
//        }else {
//            b
//        }
//    }
//
//    fun maxOf(a: Int, b: Int): Int{
//        if(a > b){
//            return a
//        }else {
//            return b
//        }
//    }
//
//    fun maxOfMinimum(a: Int, b: Int) = if(a > b) a else b


//    fun sum(a: Int, b: Int){
//        println("$a 과 $b 의 합은 ${a+b}")
//    }

//    fun sum(a: Int, b: Int): Unit{
//        println(sum(1,2f))
//    }

//    println(sum(1, 2 f))
//    fun sum(a: Int, b: Float) = a + b

