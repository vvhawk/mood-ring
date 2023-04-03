package com.example.moodring

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface JourneyEntryDao
{
    @Insert
    fun insertEntry(entry: JourneyEntry)

    @Query("SELECT * FROM journey_entries")
    fun getAll(): Flow<List<JourneyEntry>>

    @Delete
    fun deleteEntry(entry: JourneyEntry)

    @Query("DELETE FROM journey_entries")
    fun deleteAll()


}