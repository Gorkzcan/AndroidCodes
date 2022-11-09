package com.gorkemozcan.pillreminder.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
class Pill(@ColumnInfo(name="name")
var pillName : String,
@ColumnInfo(name = "time")
var time : String?
)  {
}