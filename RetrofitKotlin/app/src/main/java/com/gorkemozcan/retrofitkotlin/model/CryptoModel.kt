package com.gorkemozcan.retrofitkotlin.model

import com.google.gson.annotations.SerializedName

data class CryptoModel (
    //@SerializedName("curreny")
    // java için böyle bir serileştirme yapmamız gerekiyor ancak kotlinde değişken isimleri çekeceğimiz veriyle aynıysa bunu yapmamıza gerek kalmıyor
    val currency:String,

    // @SerializedName("price")
    val price : String
    )