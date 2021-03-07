package com.kamil.ainullov.domain.repository

import com.kamil.ainullov.domain.entity.SimpleLaunchEntity

interface PastLaunchesRepository {

    suspend fun getPastLaunches(): List<SimpleLaunchEntity>

}