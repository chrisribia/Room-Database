package com.example.lateroomdb.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Note (
    val title : String,
    val note : String
){
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}