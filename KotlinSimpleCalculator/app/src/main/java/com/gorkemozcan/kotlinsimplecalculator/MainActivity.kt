package com.gorkemozcan.kotlinsimplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gorkemozcan.kotlinsimplecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    var number1 : Int? = null
    var number2 : Int? = null
    var result : Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }


    fun mySum(view : View)
    {
        number1 = binding.editTextNumber.text.toString().toIntOrNull()
        number2 = binding.editTextNumber2.text.toString().toIntOrNull()

        if(number1 == null || number2 == null) {
            binding.resultText.text = "Error!"

        }
        else{
            result = number1!! + number2!!
            binding.resultText.text = "Result : $result"
        }

    }

    fun mySub(view : View)
    {
        number1 = binding.editTextNumber.text.toString().toIntOrNull()
        number2 = binding.editTextNumber2.text.toString().toIntOrNull()
        if(number1 == null || number2 == null)
        {
            binding.resultText.text = "Erorr!"
        }
        else
        {
            result = number1!! - number2!!
            binding.resultText.text = "Result : ${result}"
        }
    }

    fun myMultiply(view : View)
    {
        number1 = binding.editTextNumber.text.toString().toIntOrNull()
        number2 = binding.editTextNumber2.text.toString().toIntOrNull()
        if(number1 == null || number2 == null)
        {
            binding.resultText.text = "Erorr!"
        }
        else
        {
            result = number1!! * number2!!
            binding.resultText.text = "Result : ${result}"
        }
    }

    fun myDiv(view : View)
    {
        number1 = binding.editTextNumber.text.toString().toIntOrNull()
        number2 = binding.editTextNumber2.text.toString().toIntOrNull()
        if(number1 == null || number2 == null)
        {
            binding.resultText.text = "Erorr!"
        }
        else
        {
            result = number1!! / number2!!
            binding.resultText.text = "Result : ${result}"
        }
    }




}