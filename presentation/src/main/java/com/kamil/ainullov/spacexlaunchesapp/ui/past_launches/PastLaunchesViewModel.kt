package com.kamil.ainullov.spacexlaunchesapp.ui.past_launches

import androidx.lifecycle.viewModelScope
import com.kamil.ainullov.domain.core.Result
import com.kamil.ainullov.domain.entity.SimpleLaunchEntity
import com.kamil.ainullov.domain.usecase.GetPastLaunchesUseCase
import com.kamil.ainullov.spacexlaunchesapp.base.BaseViewModel
import com.kamil.ainullov.spacexlaunchesapp.utils.state.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PastLaunchesViewModel @Inject constructor(
    private val getPastLaunchesUseCase: GetPastLaunchesUseCase
): BaseViewModel<PastLaunchesContract.Event, PastLaunchesContract.State, PastLaunchesContract.Effect>() {

    /**
     * Create initial State of Views
     */
    override fun createInitialState() =
        PastLaunchesContract.State(PastLaunchesContract.PastLaunchesState.Idle)

    /**
     * Handle each event
     */
    override fun handleEvent(event: PastLaunchesContract.Event) {
        when (event) {
            is PastLaunchesContract.Event.GetPastLaunches -> getPastLaunches()
        }
    }

    private fun getPastLaunches() {
        viewModelScope.launch {
            // Set Loading
            setState { copy(pastLaunchesState = PastLaunchesContract.PastLaunchesState.Loading) }
            when (val result = getPastLaunchesUseCase.invoke(Unit)) {
                is Result.Success -> {
                    // Update state
                    setState { copy(pastLaunchesState = PastLaunchesContract.PastLaunchesState.Success(launches = result.data)) }
                }
                is Result.Error -> {
                    // Update state
                    setState { copy(pastLaunchesState = PastLaunchesContract.PastLaunchesState.Idle) }
                    // Show error
                    setEffect { PastLaunchesContract.Effect.ShowErrorDialog(result.failure) }
                }
            }
        }
    }
}