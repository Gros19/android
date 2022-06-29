package com.example.videoview

import android.content.Context
import android.media.AudioManager
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class AudioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio)
    }

    fun Audio(v: View){

        var audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        /*오디오 설정 값을 받아올 수 있다.*/
        audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)
        audioManager.getStreamVolume(AudioManager.STREAM_VOICE_CALL)
        audioManager.getStreamVolume(AudioManager.STREAM_RING)
        audioManager.getStreamVolume(AudioManager.STREAM_ALARM)

        /*오디오 index만큼 설정*/
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 5, 0)

        /*음소거*/
        audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE, 0)
        /*1증가*/
        audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE, 0)
        /*1감소*/
        audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_LOWER, 0)
        /*음소거 취소*/
        audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_UNMUTE, 0)
    }
}