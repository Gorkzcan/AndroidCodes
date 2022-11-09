package com.gorkemozcan.kotlincoroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    println("run blocking start")
    runBlocking {
        launch {
            delay(5000)
            println("run blocking end")
        }
        println("coroutine Scope start")
        coroutineScope {
            launch {
                delay(3000)
                println("coroutine scope")
            }
        }
    }

}