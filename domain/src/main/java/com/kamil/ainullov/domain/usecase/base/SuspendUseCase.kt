package com.kamil.ainullov.domain.usecase.base

import com.kamil.ainullov.domain.core.Result

interface SuspendUseCase<out T, in Params> {

    suspend operator fun invoke(params: Params): Result<T>

}