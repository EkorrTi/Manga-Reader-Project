package com.example.mangareaderproject

import android.app.Application
import com.example.mangareaderproject.room.AppDatabase

class MangaReaderProjectApplication: Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}