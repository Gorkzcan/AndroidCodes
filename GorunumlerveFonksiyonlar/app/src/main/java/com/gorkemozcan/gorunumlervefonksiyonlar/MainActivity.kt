package com.gorkemozcan.gorunumlervefonksiyonlar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //SINIFLAR

        val homer = Simpson(50, "Homer Simpson", "Nuclear")
        homer.hairColor = "Yellow"
        //homer.changeHairColor()
        //Object & Instance
        //homer.name = "Homer"
        //homer.age = 60
        //homer.job = "Nuc"
        println(homer.age)
        println(homer.hairColor)

        //Nullability
        //Nullable -> yapabilmek için (?) kullanılır.
        //Non- nullable

        var myString : String? = null //-> boşluktur artık nullable string
        var myAge : Int? = null
        //println(myString)
        //println(myAge)
        //println(myAge!! * 10) // -> ancak burada biz değeri kesinlikle oradaymış gibi eşitlediğimiz için değer gelmezse app çöker
        //println(myAge!! * 10)
        //!! myAge'in değeri orada demektir. Yani nullable yapmış olsak bile yazılım artık buna izin verir  hale gelecektir.
        //Normalde boşlukla herhangi bir sayıyı çarpamayız.


        //!! kesinlikle var
        //? var mı yok mu bilmiyoruz

        // 1) null safety
        if (myAge != null)
        {
            println(myAge * 10)
        }
        else {
            println("myAge null")
        }

        // 2)safe call

        println(myAge?.compareTo(2))

        // 3) elvis
        val myResult =   myAge?.compareTo(2) ?: -100 // -> eğer burası null çıkarsa değerii -100'e eşitle dedik.
        println(myResult)




    }

    fun helloKotlin(view: View)
    {
    println("Hello Kotlin")
        textView.text = "Hello Kotlin"
    }





}