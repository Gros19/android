package com.example.ebest

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.CallSuper
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.ebest.api.SocketManager

class MainActivity2 : AppCompatActivity() , ActivityCompat.OnRequestPermissionsResultCallback {
    internal var m_bLoginStatus = false;
    internal var m_nHandle = -1;
    internal var handler: ProcMessageHandler? = null

    internal inner class ProcMessageHandler: Handler(){
        @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            when (msg.what) {
                Log.d("tag :", ""+msg+"msg")->
                    print("\n")
            }
            }
    }


    lateinit internal var manager: SocketManager






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        /*SocketManager instance 가져오기*/
        handler = ProcMessageHandler()
        manager = (application as ApplicationManager).getSockInstance()

        manager.setRes(this, "res")

        /*공인인증서 인증을 위한 권한*/
        manager.checkPermission(this, handler as Handler)
        manager.setAutoLogin(true)



    }

    /*퍼미션 관련 콜백*/
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        /*권한 거부 시 앱을 종료함*/
        for( i in 0 .. grantResults.size-1){
            if(grantResults[i] == -1){
                /*해당 앱 루트 액티비티를 종료*/
                finishAffinity()
                /*현재 작업중인 쓰레드가 종료되면 종료시키라는 명령*/
                System.runFinalization()
                /*현재 액티비티를 종료*/
                System.exit(0)
            }
        }
    }

    /*로그인*/
    private fun LoginProcess(){
        if(m_bLoginStatus == false){
            /*로그인 화면 호출*/
            var intent = Intent(this, sLoginSet::class.java)
            startActivityForResult(intent, 1)
        }else{
            /*로그아웃*/
            manager.logout()
            manager.disconnect()

            Toast.makeText(this, "로그아웃 완료", Toast.LENGTH_LONG).show()
            checkloginstatus(false)
        }
    }

    private fun checkloginstatus(loginstatus : Boolean){


        val main = findViewById<LinearLayout>(R.id.navi_log)
        val name = main.findViewById<TextView>(R.id.btn_name)
        val img = main.findViewById<ImageView>(R.id.btn_icon)

        if(loginstatus){
            name.setText("로그아웃")
            name.setTextColor(Color.rgb(210, 34, 34))
            img.setImageResource(R.drawable.ic_launcher_background)
            Toast.makeText(applicationContext, "로그인 완료", Toast.LENGTH_SHORT).show()

        }else{
            name.setText("로그인")
            name.setTextColor(Color.rgb(0,0,0))
            img.setImageResource(R.color.white)
        }
        m_bLoginStatus = loginstatus
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        /*LoginProcess 결과값*/
        when(requestCode){
            Activity.RESULT_OK ->{
                checkloginstatus(true)
            }
            Activity.RESULT_CANCELED ->{
                checkloginstatus(false)
            }
        }
    }

    fun onMessege(msg : Message){
        when(msg.what){
            /*SOCEkT이 연결이 끊어졌다.
            * const val RECEIVE_DISCONNECT = -3   //SOCKET이 연결종료된 경우
            * const val RECEIVE_RECONNECT = 5     // SOCKET종료후 재연결 완료
            * */
            -3 -> {
                val strMsg = msg.obj as String
                Toast.makeText(applicationContext, strMsg, Toast.LENGTH_SHORT).show()
            }

            5 -> {
                var strMsg = "재연결" + msg.obj.toString()
                Toast.makeText(applicationContext, strMsg, Toast.LENGTH_SHORT).show()
            }
        }
    }


}