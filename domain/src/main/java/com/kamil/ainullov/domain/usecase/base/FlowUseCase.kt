package com.kamil.ainullov.domain.usecase.base

import kotlinx.coroutines.flow.Flow
import com.kamil.ainullov.domain.core.Result

interface FlowUseCase<out T, in Params> {

    suspend operator fun invoke(params: Params): Flow<Result<T>>

}