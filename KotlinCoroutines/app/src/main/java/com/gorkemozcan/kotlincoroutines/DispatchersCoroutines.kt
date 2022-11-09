package com.gorkemozcan.kotlincoroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main()
{
    //Dispatchers
    //Dispatchers.Default -> CPU Intensive yani cpuyu çok yoğun kullandığı işlemlerde kullanılır.
    //Görüntü işleme, içinde 100.000 kelime varsa bir dizinin onu dizme işleme gibi işlemler
    //Dispatchers.IO -> Input /Output -> Networking -> internetten veri çekmek. Database veri çekmek Retrofit
    //Dispatcher.Main -> UI işlemleri, kullanıcı arayüzü işlemleri gösterme işlemleri
    //Dİspatchers.Unconfined -> Inherited Dispatcher -> Miras alıyor.



    runBlocking {

        launch(Dispatchers.Main) {
            println("Main Thread : ${Thread.currentThread().name}")
        }
        launch(Dispatchers.IO){
            println("IO Thread : ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Default) {
            println("Default Thread : ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Unconfined){
            println("Unconfined Thrad: ${Thread.currentThread().name}")
        }
    }

}