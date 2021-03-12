package com.kamil.ainullov.cache.source

import com.kamil.ainullov.cache.db.dao.PastLaunchesDao
import com.kamil.ainullov.cache.db.dao.UpcomingLaunchesDao
import com.kamil.ainullov.cache.db.mapper.PastLaunchMapper
import com.kamil.ainullov.cache.db.mapper.SimplePastLaunchMapper
import com.kamil.ainullov.cache.db.mapper.SimpleUpcomingLaunchMapper
import com.kamil.ainullov.cache.db.mapper.UpcomingLaunchMapper
import com.kamil.ainullov.cache.utils.executeLocalRequest
import com.kamil.ainullov.data.source.LaunchesLocalDataSource
import com.kamil.ainullov.domain.core.Result
import com.kamil.ainullov.domain.entity.LaunchEntity
import com.kamil.ainullov.domain.entity.SimpleLaunchEntity
import com.kamil.ainullov.domain.utils.ext.mapResult
import com.kamil.ainullov.domain.utils.ext.mapResultList
import javax.inject.Inject

class LaunchesLocalDataSourceImpl @Inject constructor(
    private val upcomingLaunchesDao: UpcomingLaunchesDao,
    private val pastLaunchesDao: PastLaunchesDao,
    private val pastLaunchMapper: PastLaunchMapper,
    private val upcomingLaunchMapper: UpcomingLaunchMapper,
    private val simplePastLaunchMapper: SimplePastLaunchMapper,
    private val simpleUpcomingLaunchMapper: SimpleUpcomingLaunchMapper,
) : LaunchesLocalDataSource {

    override suspend fun getPastLaunches(): Result<List<SimpleLaunchEntity>> =
        executeLocalRequest { pastLaunchesDao.getPastLaunches() }
            .mapResultList(simplePastLaunchMapper)

    override suspend fun getPastLaunch(id: String): Result<LaunchEntity> =
        executeLocalRequest { pastLaunchesDao.getPastLaunch(id) }
            .mapResult(pastLaunchMapper)

    override suspend fun savePastLaunches(launches: List<SimpleLaunchEntity>) =
        pastLaunchesDao.insertPastLaunches(launches.map { simplePastLaunchMapper.mapTo(it) })

    override suspend fun savePastLaunch(launch: LaunchEntity) =
        pastLaunchesDao.insertPastLaunch(pastLaunchMapper.mapTo(launch))

    override suspend fun getUpcomingLaunches(): Result<List<SimpleLaunchEntity>> =
        executeLocalRequest { upcomingLaunchesDao.getUpcomingLaunches() }
            .mapResultList(simpleUpcomingLaunchMapper)

    override suspend fun getUpcomingLaunch(id: String): Result<LaunchEntity> =
        executeLocalRequest { upcomingLaunchesDao.getUpcomingLaunch(id) }
            .mapResult(upcomingLaunchMapper)

    override suspend fun saveUpcomingLaunches(launches: List<SimpleLaunchEntity>) =
        upcomingLaunchesDao.insertUpcomingLaunches(launches.map { simpleUpcomingLaunchMapper.mapTo(it) })

    override suspend fun saveUpcomingLaunch(launch: LaunchEntity) =
        upcomingLaunchesDao.insertUpcomingLaunch(upcomingLaunchMapper.mapTo(launch))
}