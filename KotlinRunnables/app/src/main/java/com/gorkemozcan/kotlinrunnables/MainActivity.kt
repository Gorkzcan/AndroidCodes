package com.gorkemozcan.kotlinrunnables

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var number = 0
    var runnable : Runnable = Runnable {}
    var handler : Handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    fun start(view: View)
    {

        runnable = object : Runnable {
            override fun run() {
                number++
                textView.text = "Time: "+number
                handler.postDelayed(this, 1000)
                button.setEnabled(false) // butona tekrar basmayı deaktif ettik
            }


        }
        handler.post(runnable)

    }


    fun stop(view: View)
    {
        button.setEnabled(true) // Yukarıda deaktif ettiğimiz butonu tekrar aktif ettik.

        handler.removeCallbacks(runnable)



    }
}