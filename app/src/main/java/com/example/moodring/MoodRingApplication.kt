package com.example.moodring

import android.app.Application

class MoodRingApplication : Application() {
    val db by lazy { JourneyDatabase.getInstance(this) }
}