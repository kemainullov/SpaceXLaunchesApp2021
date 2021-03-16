package com.kamil.ainullov.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kamil.ainullov.cache.db.dao.LaunchDao
import com.kamil.ainullov.cache.db.dao.PastLaunchesDao
import com.kamil.ainullov.cache.db.dao.UpcomingLaunchesDao
import com.kamil.ainullov.cache.db.model.LaunchModel
import com.kamil.ainullov.cache.db.model.SimplePastLaunchModel
import com.kamil.ainullov.cache.db.model.SimpleUpcomingLaunchModel

@Database(
    entities = [
        LaunchModel::class,
        SimplePastLaunchModel::class,
        SimpleUpcomingLaunchModel::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun launchDao(): LaunchDao
    abstract fun pastLaunchesDao(): PastLaunchesDao
    abstract fun upcomingLaunchesDao(): UpcomingLaunchesDao

}