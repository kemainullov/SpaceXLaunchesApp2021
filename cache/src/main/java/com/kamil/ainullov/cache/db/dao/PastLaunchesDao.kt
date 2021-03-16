package com.kamil.ainullov.cache.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.kamil.ainullov.cache.db.model.SimplePastLaunchModel

@Dao
interface PastLaunchesDao: BaseDao<SimplePastLaunchModel> {

    @Query("SELECT * FROM simple_past_launch")
    suspend fun getPastLaunches(): List<SimplePastLaunchModel>

    @Query("DELETE FROM simple_past_launch")
    suspend fun deleteAll()
}