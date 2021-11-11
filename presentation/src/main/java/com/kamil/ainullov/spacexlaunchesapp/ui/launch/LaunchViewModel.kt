package com.kamil.ainullov.spacexlaunchesapp.ui.launch

import androidx.lifecycle.viewModelScope
import com.kamil.ainullov.domain.core.Result
import com.kamil.ainullov.domain.usecase.GetLaunchUseCase
import com.kamil.ainullov.spacexlaunchesapp.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchViewModel @Inject constructor(
    private val getLaunchUseCase: GetLaunchUseCase
) : BaseViewModel<LaunchContract.Event, LaunchContract.State, LaunchContract.Effect>() {

    /**
     * Create initial State of Views
     */
    override fun createInitialState() = LaunchContract.State(LaunchContract.LaunchState.Idle)

    /**
     * Handle each event
     */
    override fun handleEvent(event: LaunchContract.Event) {
        when (event) {
            is LaunchContract.Event.GetLaunch -> getLaunch(launchId = event.launchId)
        }
    }

    private fun getLaunch(launchId: String) {
        viewModelScope.launch {
            // Set Loading
            setState { copy(launchState = LaunchContract.LaunchState.Loading) }
            when (val result = getLaunchUseCase.invoke(launchId)) {
                is Result.Success -> {
                    // Update state
                    setState { copy(launchState = LaunchContract.LaunchState.Success(launch = result.data)) }
                }
                is Result.Error -> {
                    // Update state
                    setState { copy(launchState = LaunchContract.LaunchState.Idle) }
                    // Show error
                    setEffect { LaunchContract.Effect.ShowErrorDialog(result.failure) }
                }
            }
        }
    }

}