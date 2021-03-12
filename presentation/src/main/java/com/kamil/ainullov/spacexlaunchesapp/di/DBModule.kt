package com.kamil.ainullov.spacexlaunchesapp.di

import android.content.Context
import androidx.room.Room
import com.kamil.ainullov.cache.db.AppDatabase
import com.kamil.ainullov.cache.db.dao.PastLaunchesDao
import com.kamil.ainullov.cache.db.dao.UpcomingLaunchesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DBModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "database-spacex-launches"
        ).build()
    }

    @Provides
    fun providePastLaunchesDao(appDatabase: AppDatabase): PastLaunchesDao {
        return appDatabase.pastLaunchesDao()
    }

    @Provides
    fun provideUpcomingLaunchesDao(appDatabase: AppDatabase): UpcomingLaunchesDao {
        return appDatabase.upcomingLaunchesDao()
    }

}