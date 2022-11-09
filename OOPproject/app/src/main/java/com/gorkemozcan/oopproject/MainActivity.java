package com.gorkemozcan.oopproject;

import static com.gorkemozcan.oopproject.HouseDecor.roomName;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        User myUser = new User();
        myUser.name = "Atil";
        myUser.job = "Instructor";

        User newUser = new User();
        newUser.name = "Kirk";
        newUser.job = "Musician";
        */

        User myUser = new User("Atil", "Instructor");
        System.out.println(myUser.information());
        System.out.println(myUser.name);

        //Encapsulation
        Musician james = new Musician("James ", "Guitar ", 50);
        int age = james.getAge();
        String name = james.getName();
        String instrument = james.getInstrument();
        System.out.println(age + name + instrument);
        james.setAge(70, "Gorkem");// Musicians.java sınıfında password tanımladık
        //eger set age kısmında bu password dogru girilmezse yapılacak olan değişim işleme tabi tutulmuyor.
        james.getAge();
        System.out.println(james.getAge());

        //Inheritance
        SuperMusician lars = new SuperMusician("lars", "Drums", 55);
        System.out.println(lars.sing());
        System.out.println(lars.getAge());
        SuperMusician gorkem = new SuperMusician("James", "Guitar", 50);
        System.out.println(gorkem.sing());
        System.out.println(gorkem.getInstrument());


        //Polymorphism

        //static polymorphism
        Mathematics mathematics = new Mathematics();
        System.out.println(mathematics.sum());
        System.out.println(mathematics.sum(5, 3));
        System.out.println(mathematics.sum(5, 3, 4));

        //dynamic polymorphism
        Animal myAnimal = new Animal();
        myAnimal.sing();
        Dog barley = new Dog();
        barley.test();
        barley.sing();

        //Abstract
        /*
        abstract sınıflar diğer sınıflar extend etsin diye oluşturulan sınıflardır.
         */

        Piano myPiano = new Piano();
        myPiano.brand = "Yamaha";
        myPiano.digital = true;
        myPiano.info();




    }
}