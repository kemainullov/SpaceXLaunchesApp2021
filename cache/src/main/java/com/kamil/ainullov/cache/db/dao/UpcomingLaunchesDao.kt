package com.kamil.ainullov.cache.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.kamil.ainullov.cache.db.model.SimpleUpcomingLaunchModel

@Dao
interface UpcomingLaunchesDao: BaseDao<SimpleUpcomingLaunchModel> {

    @Query("SELECT * FROM simple_upcoming_launch")
    suspend fun getUpcomingLaunches() : List<SimpleUpcomingLaunchModel>

    @Query("DELETE FROM simple_upcoming_launch")
    suspend fun deleteAll()

}