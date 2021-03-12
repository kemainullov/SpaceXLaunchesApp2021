package com.kamil.ainullov.cache.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kamil.ainullov.cache.db.model.PastLaunchModel
import com.kamil.ainullov.cache.db.model.SimplePastLaunchModel

@Dao
interface PastLaunchesDao {

    @Query("SELECT * FROM simple_past_launch")
    suspend fun getPastLaunches(): List<SimplePastLaunchModel>

    @Query("SELECT * FROM past_launch WHERE id = :id")
    suspend fun getPastLaunch(id: String): PastLaunchModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPastLaunches(launches: List<SimplePastLaunchModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPastLaunch(launch: PastLaunchModel)

    @Query("DELETE FROM past_launch")
    suspend fun deletePastLaunches()

    @Query("DELETE FROM simple_past_launch")
    suspend fun deleteSimplePastLaunches()
}