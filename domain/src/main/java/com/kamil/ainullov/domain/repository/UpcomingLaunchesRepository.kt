package com.kamil.ainullov.domain.repository

import com.kamil.ainullov.domain.entity.SimpleLaunchEntity
import com.kamil.ainullov.domain.core.Result

interface UpcomingLaunchesRepository {

    suspend fun getUpcomingLaunches(): Result<List<SimpleLaunchEntity>>

}