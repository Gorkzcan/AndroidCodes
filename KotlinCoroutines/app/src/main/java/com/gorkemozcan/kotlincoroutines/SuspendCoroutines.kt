package com.gorkemozcan.kotlincoroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(){
    //Suspend Function -> içerisinde coroutine çalıştırılabilen fonksiyonlardır.
    //İstedğimiz zaman durdurup devam ettirebiliriz.
    //Eğer suspend fonksiyon kullandıysak bunu bir coroutine içerisinde çalıştırmamız gerekmekteidr

    runBlocking {
        delay(2000)
        println("run blocking start")
        myFunction()
    }

}

suspend fun myFunction(){
    coroutineScope {
        delay(4000)
        println("Suspend Function")

    }
}