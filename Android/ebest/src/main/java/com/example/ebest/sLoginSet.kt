package com.example.ebest

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.ebest.api.SocketManager

class sLoginSet : AppCompatActivity(){
    internal var m_nHandle = -1
    lateinit internal var manager: SocketManager
    internal var handler: ProcMessageHandler? = null
    internal inner class ProcMessageHandler : Handler(){
        @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            when(msg.what){

            }
        }
    }

    override fun onCreate(saveInstanceState: Bundle?){
        super.onCreate(saveInstanceState)

        setContentView(R.layout.loginset_activity)
        handler = ProcMessageHandler()
        manager = (application as ApplicationManager).getSockInstance()

        this.findViewById<Button>(R.id.btn_login1).setOnClickListener {
            manager.loginPopupID(this, handler as Handler)
        }



    }
}