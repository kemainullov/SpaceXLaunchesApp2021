package com.kamil.ainullov.data.repository

import com.kamil.ainullov.data.source.LaunchesLocalDataSource
import com.kamil.ainullov.data.source.LaunchesRemoteDataSource
import com.kamil.ainullov.domain.core.Result
import com.kamil.ainullov.domain.di.IoDispatcher
import com.kamil.ainullov.domain.entity.SimpleLaunchEntity
import com.kamil.ainullov.domain.repository.PastLaunchesRepository
import kotlinx.coroutines.*
import javax.inject.Inject

class PastLaunchesRepositoryImpl @Inject constructor(
    private val launchesRemoteDataSource: LaunchesRemoteDataSource,
    private val launchesLocalDataSource: LaunchesLocalDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : PastLaunchesRepository {

    override suspend fun getPastLaunches(): Result<List<SimpleLaunchEntity>> = withContext(ioDispatcher) {
        var result = launchesRemoteDataSource.getPastLaunches()
        when (result) {
            is Result.Success -> launch { launchesLocalDataSource.savePastLaunches((result as Result.Success).data) }
            is Result.Error -> when (val localResult =
                launchesLocalDataSource.getPastLaunches()) {
                is Result.Success -> { if (localResult.data.isNotEmpty()) result = localResult }
            }
        }
        result
    }

}