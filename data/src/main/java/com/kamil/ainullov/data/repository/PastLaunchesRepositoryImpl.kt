package com.kamil.ainullov.data.repository

import com.kamil.ainullov.data.source.LaunchesRemoteDataSource
import com.kamil.ainullov.domain.core.Result
import com.kamil.ainullov.domain.entity.SimpleLaunchEntity
import com.kamil.ainullov.domain.repository.PastLaunchesRepository
import javax.inject.Inject

class PastLaunchesRepositoryImpl @Inject constructor(
    private val launchesRemoteDataSource: LaunchesRemoteDataSource,
    private val launchesLocalDataSource: LaunchesRemoteDataSource
) : PastLaunchesRepository {
    override suspend fun getPastLaunches(): Result<List<SimpleLaunchEntity>> {
        return launchesRemoteDataSource.getPastLaunches()
    }
}