package com.example.moodring

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert

@Dao
interface JourneyEntryDao
{
    @Insert
    suspend fun insertEntry(entry: JourneyEntry)

    @Delete
    suspend fun deleteEntry(entry: JourneyEntry)


}