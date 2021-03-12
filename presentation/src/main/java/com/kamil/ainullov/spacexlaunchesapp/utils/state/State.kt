package com.kamil.ainullov.spacexlaunchesapp.utils.state

import com.kamil.ainullov.domain.core.Failure

sealed class State<out T> {
    object Default : State<Nothing>()
    object Loading : State<Nothing>()
    class Error(val failure: Failure) : State<Nothing>()
    class Success<out T>(val data: T) : State<T>()
}
