package com.gorkemozcan.landmarkbookjava;

import java.io.Serializable;

public class Landmark implements Serializable {

    String name;
    String country;
    int image; // int ile tutmamızın sebebi drawable tüm resimleri int olarak tutar

    //Constructor
    public Landmark(String name, String country, int image)
    {
        this.name = name;
        this.country=country;
        this.image=image;

    }


}
