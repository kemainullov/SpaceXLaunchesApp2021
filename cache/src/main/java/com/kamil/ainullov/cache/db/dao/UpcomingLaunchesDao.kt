package com.kamil.ainullov.cache.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kamil.ainullov.cache.db.model.SimpleUpcomingLaunchModel
import com.kamil.ainullov.cache.db.model.UpcomingLaunchModel

@Dao
interface UpcomingLaunchesDao {

    @Query("SELECT * FROM simple_upcoming_launch")
    suspend fun getUpcomingLaunches() : List<SimpleUpcomingLaunchModel>

    @Query("SELECT * FROM upcoming_launch WHERE id = :id")
    suspend fun getUpcomingLaunch(id: String): UpcomingLaunchModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUpcomingLaunches(launches: List<SimpleUpcomingLaunchModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUpcomingLaunch(launch: UpcomingLaunchModel)

    @Query("DELETE FROM upcoming_launch")
    suspend fun deleteUpcomingLaunches()

    @Query("DELETE FROM simple_upcoming_launch")
    suspend fun deleteSimpleUpcomingLaunches()

}