package com.kamil.ainullov.data.source

import com.kamil.ainullov.domain.core.Result
import com.kamil.ainullov.domain.entity.LaunchEntity
import com.kamil.ainullov.domain.entity.SimpleLaunchEntity

interface LaunchesLocalDataSource {

    suspend fun getPastLaunches(): Result<List<SimpleLaunchEntity>>

    suspend fun getPastLaunch(id: String): Result<LaunchEntity>

    suspend fun savePastLaunches(launches: List<SimpleLaunchEntity>)

    suspend fun savePastLaunch(launch: LaunchEntity)


    suspend fun getUpcomingLaunches(): Result<List<SimpleLaunchEntity>>

    suspend fun getUpcomingLaunch(id: String): Result<LaunchEntity>

    suspend fun saveUpcomingLaunches(launches: List<SimpleLaunchEntity>)

    suspend fun saveUpcomingLaunch(launch: LaunchEntity)

}