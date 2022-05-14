package com.example.ebest

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
import com.ebest.api.SocketManager

class MainActivity2 : AppCompatActivity(), ActivityCompat.OnRequestPermissionsResultCallback {
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
}