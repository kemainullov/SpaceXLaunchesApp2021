package com.kamil.ainullov.data.local.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kamil.ainullov.domain.entity.LaunchEntity

interface LaunchesDao {

//    @Query("SELECT * FROM past_launches")
//    suspend fun getAllPastLaunches() : List<LaunchEntity>
//
//    @Query("SELECT * FROM upcoming_launches")
//    suspend fun getAllUpcomingLaunches() : List<LaunchEntity>
//
//    @Query("SELECT * FROM past_launches WHERE id = :id")
//    suspend fun getPastLaunch(id: String): LaunchEntity
//
//    @Query("SELECT * FROM upcoming_launches WHERE id = :id")
//    suspend fun getUpcomingLaunch(id: String): LaunchEntity
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertAllPastLaunches(launches: List<LaunchEntity>)
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertAllUpcomingLaunches(launches: List<LaunchEntity>)
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insert(launch: LaunchEntity)
//
//    @Query("DELETE FROM past_launches")
//    suspend fun deleteAllPastLaunches()
//
//    @Query("DELETE FROM upcoming_launches")
//    suspend fun deleteAllUpcomingLaunches()
}