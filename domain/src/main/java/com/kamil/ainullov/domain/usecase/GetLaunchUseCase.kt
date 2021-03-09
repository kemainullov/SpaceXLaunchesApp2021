package com.kamil.ainullov.domain.usecase

import com.kamil.ainullov.domain.entity.LaunchEntity
import com.kamil.ainullov.domain.usecase.base.SuspendUseCase
import com.kamil.ainullov.domain.core.Result
import com.kamil.ainullov.domain.repository.LaunchRepository
import javax.inject.Inject

class GetLaunchUseCase @Inject constructor(
    private val launchRepository: LaunchRepository
) : SuspendUseCase<LaunchEntity, String> {
    override suspend fun invoke(params: String): Result<LaunchEntity> {
        return launchRepository.getLaunch(launchId = params)
    }
}