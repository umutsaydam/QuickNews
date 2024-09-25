package com.umutsaydam.quicknewsapp.data.local

import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.umutsaydam.quicknewsapp.domain.model.Article

@Database(entities = [Article::class], version = 1, exportSchema = false)
@TypeConverters(NewsTypeConverter::class)
abstract class NewsDatabase : RoomDatabase() {
    abstract val newsDao: NewsDao
}