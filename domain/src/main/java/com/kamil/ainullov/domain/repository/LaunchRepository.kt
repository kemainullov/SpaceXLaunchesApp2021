package com.kamil.ainullov.domain.repository

import com.kamil.ainullov.domain.entity.LaunchEntity
import com.kamil.ainullov.domain.core.Result

interface LaunchRepository {

    suspend fun getLaunch(launchId: String): Result<LaunchEntity>

}