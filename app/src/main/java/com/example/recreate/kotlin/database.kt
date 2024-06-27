package com.example.recreate.kotlin

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class database:RoomDatabase() {

    abstract fun itemdao():itemdao
    companion object{
        private var INSTANCE:database?= null

        fun getdatabase(context: Context):database{
            return INSTANCE?: synchronized(this){
                val instance= Room.databaseBuilder(context.applicationContext,database::class.java,"itemdatabase")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE=instance
                return instance
            }
        }
    }
}