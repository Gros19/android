package com.example.ebest

import android.app.Application
import com.ebest.api.SocketManager

class ApplicationManager : Application() {

    private val sock = SocketManager()

    fun getSockInstance(): SocketManager{
        return sock
    }

    override fun onCreate() {
        super.onCreate()
        sock.init(this, applicationContext)
    }
}