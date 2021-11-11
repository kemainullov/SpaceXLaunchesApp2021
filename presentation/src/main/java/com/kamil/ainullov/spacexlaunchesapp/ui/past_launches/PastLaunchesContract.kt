package com.kamil.ainullov.spacexlaunchesapp.ui.past_launches

import com.kamil.ainullov.domain.core.Failure
import com.kamil.ainullov.domain.entity.SimpleLaunchEntity
import com.kamil.ainullov.spacexlaunchesapp.base.UiEffect
import com.kamil.ainullov.spacexlaunchesapp.base.UiEvent
import com.kamil.ainullov.spacexlaunchesapp.base.UiState

class PastLaunchesContract {

    // Events that user performed
    sealed class Event : UiEvent {
        object GetPastLaunches : Event()
    }

    // Side effects
    sealed class Effect : UiEffect {
        class ShowErrorDialog(val failure: Failure) : Effect()
    }

    // Ui View States
    data class State(
        val pastLaunchesState: PastLaunchesState
    ) : UiState

    // View State that related to past launches
    sealed class PastLaunchesState: UiState {
        object Idle : PastLaunchesState()
        object Loading : PastLaunchesState()
        data class Success(val launches : List<SimpleLaunchEntity>) : PastLaunchesState()
    }

}