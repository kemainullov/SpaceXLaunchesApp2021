package com.kamil.ainullov.spacexlaunchesapp.ui.upcoming_launches

import androidx.lifecycle.viewModelScope
import com.kamil.ainullov.domain.core.Result
import com.kamil.ainullov.domain.usecase.GetUpcomingLaunchesUseCase
import com.kamil.ainullov.spacexlaunchesapp.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpcomingLaunchesViewModel @Inject constructor(
    private val getUpcomingLaunchesUseCase: GetUpcomingLaunchesUseCase
) : BaseViewModel<UpcomingLaunchesContract.Event, UpcomingLaunchesContract.State, UpcomingLaunchesContract.Effect>() {

    /**
     * Create initial State of Views
     */
    override fun createInitialState() =
        UpcomingLaunchesContract.State(UpcomingLaunchesContract.UpcomingLaunchesState.Idle)

    /**
     * Handle each event
     */
    override fun handleEvent(event: UpcomingLaunchesContract.Event) {
        when (event) {
            is UpcomingLaunchesContract.Event.GetUpcomingLaunches -> getUpcomingLaunches()
        }
    }

    private fun getUpcomingLaunches() {
        viewModelScope.launch {
            // Set Loading
            setState { copy(upcomingLaunchesState = UpcomingLaunchesContract.UpcomingLaunchesState.Loading) }
            when (val result = getUpcomingLaunchesUseCase.invoke(Unit)) {
                is Result.Success -> {
                    // Update state
                    setState { copy(upcomingLaunchesState = UpcomingLaunchesContract.UpcomingLaunchesState.Success(launches = result.data)) }
                }
                is Result.Error -> {
                    // Update state
                    setState { copy(upcomingLaunchesState = UpcomingLaunchesContract.UpcomingLaunchesState.Idle) }
                    // Show error
                    setEffect { UpcomingLaunchesContract.Effect.ShowErrorDialog(result.failure) }
                }
            }
        }
    }
}