package io.github.m4rzb4ni.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.m4rzb4ni.data.dao.PropertyDao
import io.github.m4rzb4ni.data.database.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "estateflow_db"
        ).build()
    }

    @Provides
    fun providePropertyDao(db: AppDatabase): PropertyDao = db.propertyDao()
}