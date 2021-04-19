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
): BaseViewModel() {

    private val _pastLaunchesState = MutableStateFlow<State<List<SimpleLaunchEntity>>>(State.Default)
    val pastLaunchesState: StateFlow<State<List<SimpleLaunchEntity>>> get() = _pastLaunchesState

    fun getPastLaunches() {
        _pastLaunchesState.value = State.Loading
        viewModelScope.launch {
            when (val result = getPastLaunchesUseCase.invoke(Unit)) {
                is Result.Success -> _pastLaunchesState.value = State.Success(result.data)
                is Result.Error -> _pastLaunchesState.value = State.Error(result.failure)
            }
        }
    }
}