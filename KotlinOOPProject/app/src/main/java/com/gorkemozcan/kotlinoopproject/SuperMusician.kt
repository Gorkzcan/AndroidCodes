package com.gorkemozcan.kotlinoopproject

class SuperMusician(name: String, instrument: String, age: Int) : Musician(name, instrument, age) {

    fun sing()
    {
        println("Nothing Else Matters")
    }
}