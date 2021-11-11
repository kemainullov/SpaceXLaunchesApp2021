package com.kamil.ainullov.spacexlaunchesapp.ui.upcoming_launches

import com.kamil.ainullov.domain.core.Failure
import com.kamil.ainullov.domain.entity.SimpleLaunchEntity
import com.kamil.ainullov.spacexlaunchesapp.base.UiEffect
import com.kamil.ainullov.spacexlaunchesapp.base.UiEvent
import com.kamil.ainullov.spacexlaunchesapp.base.UiState

class UpcomingLaunchesContract {
    // Events that user performed
    sealed class Event : UiEvent {
        object GetUpcomingLaunches : Event()
    }

    // Side effects
    sealed class Effect : UiEffect {
        class ShowErrorDialog(val failure: Failure) : Effect()
    }

    // Ui View States
    data class State(
        val upcomingLaunchesState: UpcomingLaunchesState
    ) : UiState

    // View State that related to upcoming launches
    sealed class UpcomingLaunchesState: UiState {
        object Idle : UpcomingLaunchesState()
        object Loading : UpcomingLaunchesState()
        data class Success(val launches : List<SimpleLaunchEntity>) : UpcomingLaunchesState()
    }
}