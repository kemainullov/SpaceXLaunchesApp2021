package com.kamil.ainullov.data.repository

import com.kamil.ainullov.data.source.LaunchesRemoteDataSource
import com.kamil.ainullov.domain.core.Result
import com.kamil.ainullov.domain.entity.SimpleLaunchEntity
import com.kamil.ainullov.domain.repository.UpcomingLaunchesRepository
import javax.inject.Inject

class UpcomingLaunchesRepositoryImpl @Inject constructor(
    private val launchesRemoteDataSource: LaunchesRemoteDataSource,
    private val launchesLocalDataSource: LaunchesRemoteDataSource
) : UpcomingLaunchesRepository {
    override suspend fun getUpcomingLaunches(): Result<List<SimpleLaunchEntity>> {
        return launchesRemoteDataSource.getUpcomingLaunches()
    }
}