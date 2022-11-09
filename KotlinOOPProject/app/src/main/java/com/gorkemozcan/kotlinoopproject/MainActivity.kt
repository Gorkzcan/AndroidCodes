package com.gorkemozcan.kotlinoopproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Constructor

        var myUser = User("James", 50)
        myUser.name = "Lars"
        myUser.age = 60
        println(myUser.age)
        println(myUser.name)
        println(myUser.information())

        // encapsulation

        var james = Musician("james","guitar", 55)
        //james.age = 60
        println(james.age)

        println(james.returnBandName("Gorkem"))
        println(james.returnBandName("Kirk"))

        //inheritance

        var lars = SuperMusician("Lars", "Drums", 65)
        println(lars.name)
        println(lars.returnBandName("Gorkem"))
        lars.sing()

        //polymorphism
        //static polymorphism

        var mathematics = Mathematics()
        println(mathematics.sum())
        println(mathematics.sum(3,4))
        println(mathematics.sum(3,4,5))
        //dynamic polymorphism

        val animal = Animal()
        animal.sing()


        val barley = Dog()
        barley.test()
        barley.sing()


        //Abstract & interface


        //var myPeople = People() -> objesi oluşturulamaz

        var myPiano = Piano()
        myPiano.brand = "Yamaha"
        myPiano.digital = false
        println(myPiano.roomName)
        myPiano.info()


        //Lambda Expressions

        fun printString(myString : String)
        {
            println(myString)
        }

        printString("My Test String")

        val testString = {myString : String -> println(myString)}
        testString("My Lambda String")


        val multiplyLambda = {a: Int, b:Int  -> a * b}

        println(multiplyLambda(3,5))


        val multiplyLambda2 : (Int, Int) -> Int = {a,b -> a*b}
        println(multiplyLambda2(5,5))


        //asyncchrnous -> asenkronize

        //callback function, listener function, completion function

        fun downloadMusicians(url: String, completion : () -> Unit) //boş bir şey boş bir şey döndürecek ki içerde Url'den indirdiğimiz verilerin indiğinden emin olup işleme devam edebilelim
        {
            //url -> download
            //data
            completion()
        }

        downloadMusicians("metallica.com", {
            println("completed && ready")
        })



    }
}