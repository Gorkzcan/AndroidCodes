package com.gorkemozcan.mapskotlin.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gorkemozcan.mapskotlin.model.Place


@Database(entities = arrayOf(Place::class), version = 1)
abstract class PlaceDatabase : RoomDatabase(){
    abstract fun placeDao(): PlaceDao
}
