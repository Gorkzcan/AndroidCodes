package com.gorkemozcan.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Light Weightness


/*
        GlobalScope.launch {
            //kapsam
            repeat(100000) {
                //100 bin kere tekrar et dioyruz.
                launch{
                    println("android")
                }
            }
       }
 */
        //Scope -> Kapsam -> Coroutines'in nerede çalıştırılacağını belirliyor.
        //Global Scope -> Tüm uygulamada Coroutines kullanacağımızı söylüyoruz.
        //runBlocking -> BLoklayarak bir scope oluşturuyoruz.
        //CoroutineScope -> İçerisindeki tüm coroutinesler bitene kadar çalıştırıyor. Genelde bunu kullanırız.
        /*
        //runBlocking
        println("run blocking start")
        runBlocking {
            launch {
                delay(5000)
                println("run blocking")
            }
        }
        println("run blocking end")

         */
/*
        //GlobalScope
        println("global scope start")
        GlobalScope.launch {
            delay(5000)
            println("global Scope")
        }

       println("global scope end")

 */
        //Coroutines Scope

        //Context -> Nerede çalıştırıldığı ama hangi verilerl birlikte çalıştığını soruyor

        println("start")
        CoroutineScope(Dispatchers.Default).launch {
                delay(6000)
            println("coroutine scope")
        }
        println("end")

        //Global Scope gibi ana işlemleri bloklamadan çalıştırılıyor. Bu sayede imternette biri veri gelmesini bekliyorsak
        //Kullanıcı arayüzünü rahatsız etmemiş oluyoruz.
        

    }




}