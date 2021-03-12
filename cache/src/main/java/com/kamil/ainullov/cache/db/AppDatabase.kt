package com.kamil.ainullov.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kamil.ainullov.cache.db.dao.PastLaunchesDao
import com.kamil.ainullov.cache.db.dao.UpcomingLaunchesDao
import com.kamil.ainullov.cache.db.model.PastLaunchModel
import com.kamil.ainullov.cache.db.model.SimplePastLaunchModel
import com.kamil.ainullov.cache.db.model.SimpleUpcomingLaunchModel
import com.kamil.ainullov.cache.db.model.UpcomingLaunchModel

@Database(
    entities = [
        PastLaunchModel::class,
        SimplePastLaunchModel::class,
        UpcomingLaunchModel::class,
        SimpleUpcomingLaunchModel::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun upcomingLaunchesDao(): UpcomingLaunchesDao
    abstract fun pastLaunchesDao(): PastLaunchesDao

}