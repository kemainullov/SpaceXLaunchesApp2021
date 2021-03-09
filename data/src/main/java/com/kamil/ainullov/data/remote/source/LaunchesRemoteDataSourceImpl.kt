package com.kamil.ainullov.data.remote.source

import com.kamil.ainullov.data.mapper.LaunchMapper
import com.kamil.ainullov.data.mapper.SimpleLaunchMapper
import com.kamil.ainullov.data.remote.api.LaunchesApiService
import com.kamil.ainullov.data.remote.executeRequest
import com.kamil.ainullov.data.source.LaunchesRemoteDataSource
import com.kamil.ainullov.data.utils.ext.mapResult
import com.kamil.ainullov.data.utils.ext.mapResultList
import com.kamil.ainullov.domain.core.Result
import com.kamil.ainullov.domain.entity.LaunchEntity
import com.kamil.ainullov.domain.entity.SimpleLaunchEntity
import javax.inject.Inject

class LaunchesRemoteDataSourceImpl @Inject constructor(
    private val launchesApiService: LaunchesApiService,
    private val launchesMapper: LaunchMapper,
    private val simpleLaunchesMapper: SimpleLaunchMapper
) : LaunchesRemoteDataSource {

    override suspend fun getPastLaunches(): Result<List<SimpleLaunchEntity>> =
        executeRequest { launchesApiService.getPastLaunches() }
            .mapResultList(simpleLaunchesMapper)

    override suspend fun getUpcomingLaunches(): Result<List<SimpleLaunchEntity>> =
        executeRequest { launchesApiService.getUpcomingLaunches() }
            .mapResultList(simpleLaunchesMapper)

    override suspend fun getLaunch(id: String): Result<LaunchEntity> =
        executeRequest { launchesApiService.getLaunch(id) }
            .mapResult(launchesMapper)

}
