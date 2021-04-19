package com.kamil.ainullov.spacexlaunchesapp.ui.upcoming_launches

import androidx.lifecycle.viewModelScope
import com.kamil.ainullov.domain.entity.SimpleLaunchEntity
import com.kamil.ainullov.domain.core.Result
import com.kamil.ainullov.domain.usecase.GetUpcomingLaunchesUseCase
import com.kamil.ainullov.spacexlaunchesapp.base.BaseViewModel
import com.kamil.ainullov.spacexlaunchesapp.utils.state.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpcomingLaunchesViewModel @Inject constructor(
    private val getUpcomingLaunchesUseCase: GetUpcomingLaunchesUseCase
) : BaseViewModel() {

    private val _upcomingLaunchesState = MutableStateFlow<State<List<SimpleLaunchEntity>>>(State.Default)
    val upcomingLaunchesState: StateFlow<State<List<SimpleLaunchEntity>>> get() = _upcomingLaunchesState.asStateFlow()

    fun getUpcomingLaunches() {
        _upcomingLaunchesState.value = State.Loading
        viewModelScope.launch {
            when (val result = getUpcomingLaunchesUseCase.invoke(Unit)) {
                is Result.Success -> _upcomingLaunchesState.value = State.Success(result.data)
                is Result.Error -> _upcomingLaunchesState.value = State.Error(result.failure)
            }
        }
    }
}