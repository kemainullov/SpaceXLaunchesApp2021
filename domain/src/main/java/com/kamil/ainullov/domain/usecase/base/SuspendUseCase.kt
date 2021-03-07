package com.kamil.ainullov.domain.usecase.base

import com.kamil.ainullov.domain.core.Result

interface SuspendUseCase<out T> {

    suspend operator fun invoke(): Result<T>

}