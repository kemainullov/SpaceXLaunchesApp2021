package com.kamil.ainullov.data.repository

import com.kamil.ainullov.data.source.LaunchesLocalDataSource
import com.kamil.ainullov.data.source.LaunchesRemoteDataSource
import com.kamil.ainullov.domain.core.Result
import com.kamil.ainullov.domain.di.IoDispatcher
import com.kamil.ainullov.domain.entity.SimpleLaunchEntity
import com.kamil.ainullov.domain.repository.UpcomingLaunchesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UpcomingLaunchesRepositoryImpl @Inject constructor(
    private val launchesRemoteDataSource: LaunchesRemoteDataSource,
    private val launchesLocalDataSource: LaunchesLocalDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : UpcomingLaunchesRepository {

    override suspend fun getUpcomingLaunches(): Result<List<SimpleLaunchEntity>>  = withContext(ioDispatcher) {
        var result = launchesRemoteDataSource.getUpcomingLaunches()
        when (result) {
            is Result.Success -> launch { launchesLocalDataSource.saveUpcomingLaunches((result as Result.Success).data) }
            is Result.Error -> when (val localResult =
                launchesLocalDataSource.getUpcomingLaunches()) {
                is Result.Success -> { if (localResult.data.isNotEmpty()) result = localResult }
            }
        }
        result
    }

}