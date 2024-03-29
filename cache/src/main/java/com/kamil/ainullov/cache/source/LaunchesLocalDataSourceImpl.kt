package com.kamil.ainullov.cache.source

import com.kamil.ainullov.cache.db.dao.LaunchDao
import com.kamil.ainullov.cache.db.dao.PastLaunchesDao
import com.kamil.ainullov.cache.db.dao.UpcomingLaunchesDao
import com.kamil.ainullov.cache.db.mapper.LaunchMapper
import com.kamil.ainullov.cache.db.mapper.SimplePastLaunchMapper
import com.kamil.ainullov.cache.db.mapper.SimpleUpcomingLaunchMapper
import com.kamil.ainullov.cache.utils.executeLocalRequest
import com.kamil.ainullov.data.source.LaunchesLocalDataSource
import com.kamil.ainullov.domain.core.Result
import com.kamil.ainullov.domain.entity.LaunchEntity
import com.kamil.ainullov.domain.entity.SimpleLaunchEntity
import com.kamil.ainullov.domain.utils.ext.mapResult
import com.kamil.ainullov.domain.utils.ext.mapResultList
import javax.inject.Inject

class LaunchesLocalDataSourceImpl @Inject constructor(
    private val launchDao: LaunchDao,
    private val pastLaunchesDao: PastLaunchesDao,
    private val upcomingLaunchesDao: UpcomingLaunchesDao,
    private val launchMapper: LaunchMapper,
    private val simplePastLaunchMapper: SimplePastLaunchMapper,
    private val simpleUpcomingLaunchMapper: SimpleUpcomingLaunchMapper,
) : LaunchesLocalDataSource {

    override suspend fun getPastLaunches(): Result<List<SimpleLaunchEntity>> =
        executeLocalRequest { pastLaunchesDao.getPastLaunches() }
            .mapResultList(simplePastLaunchMapper)

    override suspend fun savePastLaunches(launches: List<SimpleLaunchEntity>) =
        pastLaunchesDao.insert(launches.map { simplePastLaunchMapper.mapTo(it) })

    override suspend fun getLaunch(id: String): Result<LaunchEntity> =
        executeLocalRequest { launchDao.getLaunch(id) }
            .mapResult(launchMapper)

    override suspend fun saveLaunch(launch: LaunchEntity) =
        launchDao.insert(launchMapper.mapTo(launch))

    override suspend fun getUpcomingLaunches(): Result<List<SimpleLaunchEntity>> =
        executeLocalRequest { upcomingLaunchesDao.getUpcomingLaunches() }
            .mapResultList(simpleUpcomingLaunchMapper)

    override suspend fun saveUpcomingLaunches(launches: List<SimpleLaunchEntity>) =
        upcomingLaunchesDao.insert(launches.map { simpleUpcomingLaunchMapper.mapTo(it) })
}