package com.gorkemozcan.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Toast message çok kısa görünüp giden silik bir yazı olacak
        //Toast.makeText(this, "Toast Message", Toast.LENGTH_LONG).show();

        //Context
        //Activity Context
        /*activity context'e erişebilmek için this kullanılır
         */
        //App Context
        /*
        app context'e erişebilmek için getApplicationContext()
        */
        //Olarak ikiye ayrılıyor
    }

    public void save(View view)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Save");
        alert.setMessage("Are u sure?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //save olması gerekiyor normalde ama fonksiyonu yazmadık
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
                    //getApplicationContext() veya MainActivity.this kullanabiliriz
                    //ancak tek başına this kulanırsak onclicklistener içersinde olduğu için hata verecektir.

            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Not Saved", Toast.LENGTH_LONG).show();

            }
        });
        alert.show();
    }
}