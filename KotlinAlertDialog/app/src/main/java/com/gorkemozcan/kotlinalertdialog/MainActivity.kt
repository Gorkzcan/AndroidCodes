package com.gorkemozcan.kotlinalertdialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Context
        //Activity Context -> this
        //App Context ->applicationContext


        Toast.makeText(this@MainActivity , "Welcome", Toast.LENGTH_SHORT).show()

        /*
        button.setOnClickListener(obejct:View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(this@MainActivity, "test2", Toast.LENGTH_SHORT).show()
        }
        })
         */
    }


    fun save(view: View)
    {

        val alert = AlertDialog.Builder(this)
        alert.setTitle("Save")
        alert.setMessage("Are You Sure?")
        alert.setPositiveButton("Yes"){dialog, which ->

            //Onclick Listener
            Toast.makeText(this@MainActivity, "Saved", Toast.LENGTH_SHORT).show()
        }
        alert.setNegativeButton("No"){dialog, which ->

            //Onclick Listener
            Toast.makeText(applicationContext, "Not Saved", Toast.LENGTH_SHORT).show()
        }

        alert.setNeutralButton("Cancel") {dialog, which ->
            Toast.makeText(this@MainActivity, "Cancelled", Toast.LENGTH_SHORT).show()
        }
        //Neutralbutton çok görülmese bile önemlidir. Bu uygulama özelinde yanlışlıkla buton tıklaması yapılması durumunda iptal için eklenmiştir.
        alert.show()

    }

}