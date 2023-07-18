package com.example.actividadesmars.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(MarsEntity::class), version = 1, exportSchema = false)
abstract class MarsDB : RoomDatabase() {
    abstract fun marsDao(): MarsDAO

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: MarsDB? = null

        fun getDatabase(context: Context): MarsDB {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MarsDB::class.java,
                    "mars_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}