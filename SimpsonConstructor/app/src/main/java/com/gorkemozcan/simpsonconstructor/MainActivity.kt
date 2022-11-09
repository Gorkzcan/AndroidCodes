package com.gorkemozcan.simpsonconstructor


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gorkemozcan.simpsonconstructor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var name = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }



    fun makeSimpson(view : View)
    {

        name = binding.nameText.text.toString()
        //nameText.text -> olduğunda bize editable oluyor biz bunu toString yapmamız lazım

        var age = binding.ageText.text.toString().toIntOrNull()
        if (age == null)
        {
            age = 0
        }

        val job = binding.jobText.text.toString()
        val simpson = Simpson(name, age, job)

        //binding.resultText.text = "Name: ${simpson.name}, Age: ${simpson.age}, Job:${simpson.job}" -> kullanılır ama güvensiz çalışır app çökebilir
        binding.resultText.text = "Name : ${simpson.name}, Age: ${simpson.age}, Job:${simpson.job}"

    }
        //Scope -> Kapsam

        fun scopeExample(view : View)
        {
            println(name)
        }






}


