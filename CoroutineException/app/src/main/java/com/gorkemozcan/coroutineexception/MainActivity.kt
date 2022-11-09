package com.gorkemozcan.coroutineexception

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
            println("exception: " +throwable.localizedMessage)
        }

        /*lifecycleScope.launch(handler){
            launch {
                throw Exception("Error 2")
            }
            launch {
                delay(500L)
                println("this is executed")
            }
        }

         */

        lifecycleScope.launch(handler){
            supervisorScope {
                launch {
                    throw Exception("Error 2")
                }
                launch {
                    delay(500L)
                    println("this is executed")
                }
            }
        }
        CoroutineScope(Dispatchers.Main + handler).launch{
            launch{
                throw Exception("error in a coroutine scope")
            }
        }

            }


        }

