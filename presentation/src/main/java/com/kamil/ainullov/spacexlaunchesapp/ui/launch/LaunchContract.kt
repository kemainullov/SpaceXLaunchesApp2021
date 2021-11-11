package com.kamil.ainullov.spacexlaunchesapp.ui.launch

import com.kamil.ainullov.domain.core.Failure
import com.kamil.ainullov.domain.entity.LaunchEntity
import com.kamil.ainullov.spacexlaunchesapp.base.UiEffect
import com.kamil.ainullov.spacexlaunchesapp.base.UiEvent
import com.kamil.ainullov.spacexlaunchesapp.base.UiState

class LaunchContract {

    // Events that user performed
    sealed class Event : UiEvent {
        class GetLaunch(val launchId: String) : Event()
    }

    // Side effects
    sealed class Effect : UiEffect {
        class ShowErrorDialog(val failure: Failure) : Effect()
    }

    // Ui View States
    data class State(
        val launchState: LaunchState
    ) : UiState

    // View State that related to launch
    sealed class LaunchState: UiState {
        object Idle : LaunchState()
        object Loading : LaunchState()
        data class Success(val launch : LaunchEntity) : LaunchState()
    }

}