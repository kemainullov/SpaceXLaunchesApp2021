package com.kamil.ainullov.domain.usecase

import com.kamil.ainullov.domain.entity.SimpleLaunchEntity
import com.kamil.ainullov.domain.usecase.base.SuspendUseCase
import com.kamil.ainullov.domain.core.Result

class GetPastLaunchesUseCase() : SuspendUseCase<List<SimpleLaunchEntity>> {
    override suspend fun invoke(): Result<List<SimpleLaunchEntity>> {
        TODO("Not yet implemented")
    }
}