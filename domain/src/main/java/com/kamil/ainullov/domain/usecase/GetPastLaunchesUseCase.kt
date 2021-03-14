package com.kamil.ainullov.domain.usecase

import com.kamil.ainullov.domain.entity.SimpleLaunchEntity
import com.kamil.ainullov.domain.usecase.base.SuspendUseCase
import com.kamil.ainullov.domain.core.Result
import com.kamil.ainullov.domain.repository.PastLaunchesRepository
import javax.inject.Inject

class GetPastLaunchesUseCase @Inject constructor(
    private val pastLaunchesRepository: PastLaunchesRepository
) : SuspendUseCase<List<SimpleLaunchEntity>, Unit> {
    override suspend fun invoke(params: Unit): Result<List<SimpleLaunchEntity>> {
        return pastLaunchesRepository.getPastLaunches()
    }
}