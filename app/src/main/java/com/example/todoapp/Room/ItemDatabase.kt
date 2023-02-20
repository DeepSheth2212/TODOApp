package com.example.todoapp.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1)
abstract class ItemDatabase : RoomDatabase() {
    abstract fun ItemDao() : ItemDao

    companion object{
        @Volatile
        private var instance : ItemDatabase? = null

        fun getDatabase(context: Context): ItemDatabase{
            if (instance==null){
                synchronized(this){
                    if (instance==null){
                        instance = Room.databaseBuilder(context,
                            ItemDatabase::class.java,
                            "itemDB")
                            .build()
                    }
                }
            }
            return instance!!
        }
    }
}