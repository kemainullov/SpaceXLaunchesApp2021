package com.kamil.ainullov.domain.usecase.base

import kotlinx.coroutines.flow.Flow
import com.kamil.ainullov.domain.core.Result

interface FlowUseCase<out T> {

    suspend operator fun invoke(): Flow<Result<T>>

}