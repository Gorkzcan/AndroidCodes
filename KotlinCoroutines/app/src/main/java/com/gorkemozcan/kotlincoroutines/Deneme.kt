package com.gorkemozcan.kotlincoroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    println("run blocking start")
    runBlocking{
        launch{
            delay(5000)
            println("run blocking end")
        }
        println("Global Scope start")
        GlobalScope.launch {
            delay(3000)
            println("Global scope")
        }
    }
}