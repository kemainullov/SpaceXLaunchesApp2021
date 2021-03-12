package com.kamil.ainullov.remote.source

import com.kamil.ainullov.remote.mapper.LaunchMapper
import com.kamil.ainullov.remote.mapper.SimpleLaunchMapper
import com.kamil.ainullov.remote.api.LaunchesApiService
import com.kamil.ainullov.data.source.LaunchesRemoteDataSource
import com.kamil.ainullov.domain.core.Result
import com.kamil.ainullov.domain.entity.LaunchEntity
import com.kamil.ainullov.domain.entity.SimpleLaunchEntity
import com.kamil.ainullov.domain.utils.ext.mapResult
import com.kamil.ainullov.domain.utils.ext.mapResultList
import com.kamil.ainullov.remote.utils.executeRemoteRequest
import javax.inject.Inject

class LaunchesRemoteDataSourceImpl @Inject constructor(
    private val launchesApiService: LaunchesApiService,
    private val launchesMapper: LaunchMapper,
    private val simpleLaunchesMapper: SimpleLaunchMapper
) : LaunchesRemoteDataSource {

    override suspend fun getPastLaunches(): Result<List<SimpleLaunchEntity>> =
        executeRemoteRequest { launchesApiService.getPastLaunches() }
            .mapResultList(simpleLaunchesMapper)

    override suspend fun getUpcomingLaunches(): Result<List<SimpleLaunchEntity>> =
        executeRemoteRequest { launchesApiService.getUpcomingLaunches() }
            .mapResultList(simpleLaunchesMapper)

    override suspend fun getLaunch(id: String): Result<LaunchEntity> =
        executeRemoteRequest { launchesApiService.getLaunch(id) }
            .mapResult(launchesMapper)

}
