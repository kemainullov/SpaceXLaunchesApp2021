package com.kamil.ainullov.domain.repository

import com.kamil.ainullov.domain.entity.SimpleLaunchEntity

interface UpcomingLaunchesRepository {

    suspend fun getUpcomingLaunches(): List<SimpleLaunchEntity>

}