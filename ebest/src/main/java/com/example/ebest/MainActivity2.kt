package com.example.ebest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.os.Bundle;
import com.ebest.api.SocketManager;


public class MainActivity2 extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback{

    SocketManager manager;
//    ProcMessageHandler handler;
    int m_nHandle = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        handler = new ProcMessageHandler();
        manager = ((ApplicationManager)getApplication()).getSockInstance();

//        manager.checkPermission(this, handler);
        manager.setRes(this, "res");
    }
}