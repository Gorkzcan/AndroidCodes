package com.gorkemozcan.mapskotlin.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Place(
            @ColumnInfo(name = "name")
            var name : String,
            @ColumnInfo(name = "latitude")
            var latitude : Double,
            @ColumnInfo(name = "longitude")
            var longitude : Double

            ) {
            @PrimaryKey(autoGenerate = true) //kendisi oluşturacak bize otomatik verecek
            var id = 0


}