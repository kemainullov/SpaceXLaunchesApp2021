package com.kamil.ainullov.data.repository

import com.kamil.ainullov.data.source.LaunchesRemoteDataSource
import com.kamil.ainullov.domain.core.Result
import com.kamil.ainullov.domain.entity.LaunchEntity
import com.kamil.ainullov.domain.repository.LaunchRepository
import javax.inject.Inject

class LaunchRepositoryImpl @Inject constructor(
    private val launchesRemoteDataSource: LaunchesRemoteDataSource,
    private val launchesLocalDataSource: LaunchesRemoteDataSource
) : LaunchRepository {
    override suspend fun getLaunch(launchId: String): Result<LaunchEntity> {
        return launchesRemoteDataSource.getLaunch(launchId)
    }
}