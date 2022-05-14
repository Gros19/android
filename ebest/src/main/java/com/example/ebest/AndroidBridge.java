package com.example.ebest;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;

import com.ebest.api.SocketManager;

public class AndroidBridge {
    /**/
    /*success*/
    /**/
    /*SOCKET 연결 완료*/
    final int RECEIVE_CONNECT = 0;
    /*TR데이터 수신*/
    final int RECEIVE_DATA = 1;
    /*실시간 데이터 수신*/
    final int RECEIVE_REALDATA = 2;
    /*TR메세지 수신*/
    final int RECEIVE_MSG = 3;
    /*로그인 완료*/
    final int RECEIVE_LOGINCOMPLETE = 4;
    /*SOCKET 종료 후 재연결 완료*/
    final int RECEIVE_RECONNECT = 5;
    /*선택한 공인인증서 관련 정보*/
    final int RECEIVE_SIGN = 6;
    /*7은 ???*/

    /*TR 조회 완료*/
    final int RECEIVE_RELEASE = 8;

    /**/
    /*error*/
    /**/
    /*SOCKET 연결 에러*/
    final int RECEIVE_CONNECTERROR = -1;
    /*서버에서 내려주는 시스템에러*/
    final int RECEIVE_SYSTEMERROR = -2;
    /*SOCKET이 연결 종료된 경우*/
    final int RECEIVE_DISCONNECT = -3;
    /*일반적인 에러*/
    final int RECEIVE_ERROR = -4;
    /*권한 에러*/
    final int RECEIVE_PERMISSIONERROR = -5;
    /*initech 핸드세이킹 에러*/
    final int RECEIVE_INITECHERROR = -6;
    /*TIME 에러*/
    final int RECEIVE_TIMEOUTERROR = -7;

    private Activity m_activity;
    private WebView m_webView;
    private Context m_context;
    private ProcMessageHandler handler = new ProcMessageHandler();
    private SocketManager manager;
    private int m_nHandle = -1;

    /*생성자*/
    public AndroidBridge(WebView webView, Context context, Activity activity, SocketManager sm){
        m_webView = webView;
        m_context = context;
        m_activity = activity;
        manager = sm;

        m_webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(final WebView view, final String url, final String message, JsResult result) {
                Log.d("JsAlert", "onJsAlert(!" + view + ", " + url + ", " + message + ", " + result + ")");
                Toast.makeText(m_context, message, Toast.LENGTH_SHORT).show();
                result.confirm();
                return true; // I handled it
            }
        });
    }

    class ProcMessageHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {

                // 일반적인 에러
                case RECEIVE_ERROR: {
                    String strMsg = (String) msg.obj;
                    //Toast.makeText(m_Activity.getApplicationContext(), strMsg, Toast.LENGTH_SHORT).show();
                    m_webView.loadUrl("javascript:receiveAppMessageData('" + strMsg + "')");        // 자바스크립트 호출
                    break;
                }
                // SOCEKT이 연결이 끊어졌다.
                case RECEIVE_DISCONNECT:
                    break;

                // 서버에서 보내는 시스템 ERROR
                case RECEIVE_SYSTEMERROR:
                    break;

                // SOCKET연결이 실패했다.
                case RECEIVE_CONNECTERROR:
                    break;

                // SOCKET연결이 성공했다.
                case RECEIVE_CONNECT:
                    break;

                default:
                    break;
            }
        }

    }

    public Handler getHandler() {return handler;}

    public void setHandler(int nHandle){
        m_nHandle = nHandle;
    }

    public void loginCompleted(){
        m_webView.loadUrl("javascript:receiveAppQueryMessageData('login, 로그인 성공)");
    }

    /*LOGIN*/
    @JavascriptInterface
    public void loginPopup(String strTitle){
        manager.loginPopupID(m_activity, handler);
    }


}

