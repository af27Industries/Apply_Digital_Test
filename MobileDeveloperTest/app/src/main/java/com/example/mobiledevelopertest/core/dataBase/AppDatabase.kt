package com.example.mobiledevelopertest.core.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mobiledevelopertest.core.entity.ArticleEntity

@Database(entities = [ArticleEntity::class], version = 6, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}
