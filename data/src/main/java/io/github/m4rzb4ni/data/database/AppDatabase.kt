package io.github.m4rzb4ni.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.m4rzb4ni.data.dao.PropertyDao
import io.github.m4rzb4ni.data.entity.PropertyEntity

@Database(entities = [PropertyEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun propertyDao(): PropertyDao
}