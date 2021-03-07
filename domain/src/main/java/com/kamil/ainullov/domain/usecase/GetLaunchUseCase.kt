package com.kamil.ainullov.domain.usecase

import com.kamil.ainullov.domain.entity.LaunchEntity
import com.kamil.ainullov.domain.usecase.base.SuspendUseCase
import com.kamil.ainullov.domain.core.Result

class GetLaunchUseCase() : SuspendUseCase<LaunchEntity> {
    override suspend fun invoke(): Result<LaunchEntity> {
        TODO("Not yet implemented")
    }
}