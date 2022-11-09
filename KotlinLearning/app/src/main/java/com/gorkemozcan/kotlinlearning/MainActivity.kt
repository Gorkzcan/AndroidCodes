package com.gorkemozcan.kotlinlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        test()
        mySum(10,20)
        //javanın voidi - kotlinin unit'i oluyor
        //Return
        val Result = myMultiply(10,20)
        textView.text = "Result : ${Result}"
    }

    fun test()
    {
        println("Test Function")
    }

    //Input & Return

    fun mySum(a:Int, b:Int)
    {
        textView.text = "Result : ${a+b}"       //burada return yok

    }

    fun myMultiply(x:Int, y:Int) : Int
    {
        //en sonda :Int yaptığımız kısımda return değeri atadığımızı anlatıyor
        return x*y

    }
}