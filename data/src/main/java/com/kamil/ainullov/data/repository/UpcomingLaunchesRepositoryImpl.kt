package com.kamil.ainullov.data.repository

import com.kamil.ainullov.domain.entity.SimpleLaunchEntity
import com.kamil.ainullov.domain.repository.UpcomingLaunchesRepository

class UpcomingLaunchesRepositoryImpl() : UpcomingLaunchesRepository {
    override suspend fun getUpcomingLaunches(): List<SimpleLaunchEntity> {
        TODO("Not yet implemented")
    }
}