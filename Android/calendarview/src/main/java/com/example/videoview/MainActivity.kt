package com.example.videoview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.videoview.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

      binding.calendarView.setOnDateChangeListener{calendarView, year, month, day ->
          /*누르면 날자 출력*/
      //          println(year.toString() + "/" + month.toString() + "/" + day.toString())
          /*
        val calendar = Calendar.getInstance()
        android:minDate="04/04/2022"
        android:maxDate="05/31/2022"
        android:firstDayOfWeek="2"
        * */
      }

        val calendar = Calendar.getInstance()
        calendar.set(2022, 4, 4)
        binding.calendarView.setDate(calendar.timeInMillis)


    }
}