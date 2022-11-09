package com.gorkemozcan.kotlinsqlite

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try{
            val myDatabase = this.openOrCreateDatabase("Musicians", Context.MODE_PRIVATE, null)
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS musicians (id INTEGER PRIMARY KEY,name VARCHAR, age INT)")//bir tablo oluştur eğer yoksa ve adını musicians koy VARCHAR -> String oluyor.
            //myDatabase.execSQL("INSERT INTO musicians (name, age) VALUES ('James',50)") // -> musicians'ın içerisinde James ve 50 yi kaydet
            //myDatabase.execSQL("INSERT INTO musicians (name, age) VALUES ('Lars',60)")
            //myDatabase.execSQL("INSERT INTO musicians (name, age) VALUES ('Kirk',55)")

            //myDatabase.execSQL("UPDATE musicians SET age = 61 WHERE name = 'Lars'")//-> filtreleme yaptık sadece larsın yaşı değişecek
            //myDatabase.execSQL("UPDATE musicians SET name = 'Kirk Hammett' WHERE id = 3")
            myDatabase.execSQL("DELETE FROM musicians WHERE name = 'Lars'")

            val cursor = myDatabase.rawQuery("SELECT * FROM musicians ",null)
            //val cursor = myDatabase.rawQuery("SELECT * FROM musicians WHERE name = 'James'", null) //-> * her şeyi demektir. Burada musicianstan her şeyi seç, selectionArgs -> filtre
            //val cursor = myDatabase.rawQuery("SELECT * FROM musicians WHERE id = 3", null)
            //val cursor = myDatabase.rawQuery("SELECT * FROM musicians WHERE name LIKE '%s'", null) //-> LIKE %s yapınca sonu s ile biten isimleri getirecektir.
            //val cursor = myDatabase.rawQuery("SELECT * FROM musicians WHERE name LIKE 'K%'", null) //-> K ile başlayan isimleri getirecektir


//where olduğunda filtreleme yapıyoruz.


            val nameIx = cursor.getColumnIndex("name")
            val ageIx = cursor.getColumnIndex("age")
            val idIx = cursor.getColumnIndex("id")
            while(cursor.moveToNext()){
                println("Name: "+ cursor.getString(nameIx))
                println("Age : "+cursor.getInt(ageIx))
                println("İd : "+cursor.getInt(idIx))
            }
            cursor.close()
        }catch (e: Exception) {
            e.printStackTrace()
        }



    }
}