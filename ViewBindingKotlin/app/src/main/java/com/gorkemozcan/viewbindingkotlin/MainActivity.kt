package com.gorkemozcan.viewbindingkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.gorkemozcan.viewbindingkotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    //private lateinit var textView : TextView
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //textView = findViewById<TextView>(R.id.textView)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    fun ismiDegistir(view : View)
    {
        //textView.text = "merhaba Kotlin"
        println("Degistir Tiklandi")
        //val textView = findViewById<TextView>(R.id.textView)
        //textView.text = "Merhaba Kotlin"
        binding.textView.text  = "Merhaba Kotlin"

    }
}