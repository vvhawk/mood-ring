package com.example.moodring

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "journey_entries")
data class JourneyEntry(

    @ColumnInfo var select: Int,
    @ColumnInfo var date: String,
    @PrimaryKey(autoGenerate = true) val id: Long = 0,

)
