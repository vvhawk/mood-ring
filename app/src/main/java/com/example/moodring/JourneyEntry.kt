package com.example.moodring

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class JourneyEntry(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    @ColumnInfo var select: Int,
    @ColumnInfo var date: String

)
