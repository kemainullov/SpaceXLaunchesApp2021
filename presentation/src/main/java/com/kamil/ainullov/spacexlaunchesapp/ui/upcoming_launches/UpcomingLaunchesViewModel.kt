package com.kamil.ainullov.spacexlaunchesapp.ui.upcoming_launches

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kamil.ainullov.domain.entity.SimpleLaunchEntity
import com.kamil.ainullov.domain.core.Result
import com.kamil.ainullov.domain.usecase.GetUpcomingLaunchesUseCase
import com.kamil.ainullov.spacexlaunchesapp.base.BaseViewModel
import com.kamil.ainullov.spacexlaunchesapp.utils.ext.default
import com.kamil.ainullov.spacexlaunchesapp.utils.ext.post
import com.kamil.ainullov.spacexlaunchesapp.utils.ext.set
import com.kamil.ainullov.spacexlaunchesapp.utils.state.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpcomingLaunchesViewModel @Inject constructor(
    private val getUpcomingLaunchesUseCase: GetUpcomingLaunchesUseCase
) : BaseViewModel() {

    private val _upcomingLaunchesState = MutableLiveData<State<List<SimpleLaunchEntity>>>().default(initialValue = State.Default)
    val upcomingLaunchesState: LiveData<State<List<SimpleLaunchEntity>>> = _upcomingLaunchesState

    fun getUpcomingLaunches() {
        _upcomingLaunchesState.set(newValue = State.Loading)
        viewModelScope.launch {
            when (val result = getUpcomingLaunchesUseCase.invoke(Unit)) {
                is Result.Success -> _upcomingLaunchesState.post(State.Success(result.data))
                is Result.Error -> _upcomingLaunchesState.post(State.Error(result.failure))
            }
        }
    }
}