package com.gorkemozcan.retrofitkotlin.service

import com.gorkemozcan.retrofitkotlin.model.CryptoModel
import io.reactivex.rxjava3.core.Observable



import retrofit2.http.GET

interface CryptoAPI {

    //GET, POST, UPDATE, DELETE

    //get veri çekmek
    //post veri yazmak
    //update veri güncellemek
    //delete veri silmek

    //bir get işlemi yap dedik. Retrofitin kuralı gereği linkin bazını başka yerde kalanını başka yerde kullanıyoruz.
    //bir fonksiyon yarattık ve bu fonksiyonun ne istediğini verdik.
    //Bir liste halinde crypto paralar geleceğinden oluşturduğumuz modeli parametre olarak verdik.

    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    //fun getData() : Call<List<CryptoModel>>
    fun getData() : Observable<List<CryptoModel>>





}