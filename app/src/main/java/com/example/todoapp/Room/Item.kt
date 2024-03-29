package com.example.todoapp.Room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.util.Calendar
import java.util.Date

@Entity(tableName = "todolist")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val title : String ,
    val description : String ,
    val time: String,
    //val type : Int //0 for daily , and 1 for weekly as we can not store boolean inside sql database
)
