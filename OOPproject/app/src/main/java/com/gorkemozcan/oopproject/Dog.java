package com.gorkemozcan.oopproject;

public class Dog extends Animal{
    //hayvan sınıfından miras aldı.

    public void test()
    {
        super.sing();
    }

    public void sing()
    {
        System.out.println("dog class");
    }

}
