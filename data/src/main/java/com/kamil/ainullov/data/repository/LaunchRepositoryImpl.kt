package com.kamil.ainullov.data.repository

import com.kamil.ainullov.data.source.LaunchesLocalDataSource
import com.kamil.ainullov.data.source.LaunchesRemoteDataSource
import com.kamil.ainullov.domain.core.Result
import com.kamil.ainullov.domain.di.IoDispatcher
import com.kamil.ainullov.domain.entity.LaunchEntity
import com.kamil.ainullov.domain.repository.LaunchRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LaunchRepositoryImpl @Inject constructor(
    private val launchesRemoteDataSource: LaunchesRemoteDataSource,
    private val launchesLocalDataSource: LaunchesLocalDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : LaunchRepository {

    override suspend fun getLaunch(launchId: String): Result<LaunchEntity> = withContext(ioDispatcher) {
        var result = launchesRemoteDataSource.getLaunch(launchId)
        when (result) {
            is Result.Success -> launch { launchesLocalDataSource.saveLaunch((result as Result.Success).data) }
            is Result.Error -> when (val localResult = launchesLocalDataSource.getLaunch(launchId)) {
                is Result.Success -> result = localResult
            }
        }
        result
    }

}