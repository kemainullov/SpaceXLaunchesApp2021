package com.kamil.ainullov.domain.repository

import com.kamil.ainullov.domain.entity.SimpleLaunchEntity
import com.kamil.ainullov.domain.core.Result

interface PastLaunchesRepository {

    suspend fun getPastLaunches(): Result<List<SimpleLaunchEntity>>

}