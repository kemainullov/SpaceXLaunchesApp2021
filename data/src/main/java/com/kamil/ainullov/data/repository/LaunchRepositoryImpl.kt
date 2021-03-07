package com.kamil.ainullov.data.repository

import com.kamil.ainullov.domain.entity.LaunchEntity
import com.kamil.ainullov.domain.repository.LaunchRepository

class LaunchRepositoryImpl() : LaunchRepository {
    override suspend fun getLaunch(launchId: String): LaunchEntity {
        TODO("Not yet implemented")
    }
}