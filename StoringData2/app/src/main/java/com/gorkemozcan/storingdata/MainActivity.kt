package com.gorkemozcan.storingdata

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gorkemozcan.storingdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var age : Int = 0
    lateinit var sharedPreferences : SharedPreferences
    var ageFromPreferences : Int? = null

    private lateinit var  binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //SharedPreferences initialize
        sharedPreferences = this.getSharedPreferences("com.gorkemozcan.storingdata", MODE_PRIVATE)//oluşturulan dosya sadece bu uygulamadan çağırılacak

         ageFromPreferences = sharedPreferences.getInt("age", age)
        if(ageFromPreferences == age)
        {
            binding.textView.text = "Your age : "
        }
        else
        {
            binding.textView.text = "Your age :"+ageFromPreferences
        }
    }


    fun save(view : View)
    {

        var age = binding.editText.text.toString().toIntOrNull()
        if (age != null)
        {
            binding.textView.text = "Your age : "+age
            sharedPreferences.edit().putInt("age", age).apply()

        }
    }

    fun delete(view : View)
    {
        ageFromPreferences = sharedPreferences.getInt("age", age)
        if(ageFromPreferences != age)
        {
        sharedPreferences.edit().remove("age").apply()
            binding.textView.text = "Your age:"

        }

    }
}