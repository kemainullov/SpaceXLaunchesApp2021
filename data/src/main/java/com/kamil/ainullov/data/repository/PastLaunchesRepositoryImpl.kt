package com.kamil.ainullov.data.repository

import com.kamil.ainullov.domain.entity.SimpleLaunchEntity
import com.kamil.ainullov.domain.repository.PastLaunchesRepository

class PastLaunchesRepositoryImpl() : PastLaunchesRepository {
    override suspend fun getPastLaunches(): List<SimpleLaunchEntity> {
        TODO("Not yet implemented")
    }
}