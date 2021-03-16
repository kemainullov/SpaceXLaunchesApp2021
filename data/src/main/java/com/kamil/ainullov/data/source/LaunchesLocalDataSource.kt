package com.kamil.ainullov.data.source

import com.kamil.ainullov.domain.core.Result
import com.kamil.ainullov.domain.entity.LaunchEntity
import com.kamil.ainullov.domain.entity.SimpleLaunchEntity

interface LaunchesLocalDataSource {

    suspend fun getPastLaunches(): Result<List<SimpleLaunchEntity>>

    suspend fun savePastLaunches(launches: List<SimpleLaunchEntity>)

    suspend fun getLaunch(id: String): Result<LaunchEntity>

    suspend fun saveLaunch(launch: LaunchEntity)

    suspend fun getUpcomingLaunches(): Result<List<SimpleLaunchEntity>>

    suspend fun saveUpcomingLaunches(launches: List<SimpleLaunchEntity>)

}