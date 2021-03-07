package com.kamil.ainullov.domain.repository

import com.kamil.ainullov.domain.entity.LaunchEntity

interface LaunchRepository {

    suspend fun getLaunch(launchId: String): LaunchEntity

}