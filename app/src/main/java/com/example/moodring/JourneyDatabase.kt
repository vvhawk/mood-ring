package com.example.moodring

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [JourneyEntry::class],
    version = 1
)
abstract class JourneyDatabase: RoomDatabase()
{
    abstract fun journeyDao(): JourneyEntryDao

    companion object {

        @Volatile
        private var INSTANCE: JourneyDatabase? = null

        fun getInstance(context: Context): JourneyDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                JourneyDatabase::class.java, "Articles-db"
            ).build()
    }
}