package com.kamil.ainullov.spacexlaunchesapp.ui.past_launches

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kamil.ainullov.domain.core.Result
import com.kamil.ainullov.domain.entity.SimpleLaunchEntity
import com.kamil.ainullov.domain.usecase.GetPastLaunchesUseCase
import com.kamil.ainullov.spacexlaunchesapp.base.BaseViewModel
import com.kamil.ainullov.spacexlaunchesapp.utils.ext.default
import com.kamil.ainullov.spacexlaunchesapp.utils.ext.post
import com.kamil.ainullov.spacexlaunchesapp.utils.ext.set
import com.kamil.ainullov.spacexlaunchesapp.utils.state.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PastLaunchesViewModel @Inject constructor(
    private val getPastLaunchesUseCase: GetPastLaunchesUseCase
): BaseViewModel() {

    private val _pastLaunchesState = MutableLiveData<State<List<SimpleLaunchEntity>>>().default(initialValue = State.Default)
    val pastLaunchesState: LiveData<State<List<SimpleLaunchEntity>>> = _pastLaunchesState

    fun getPastLaunches() {
        _pastLaunchesState.set(newValue = State.Loading)
        viewModelScope.launch {
            when (val result = getPastLaunchesUseCase.invoke(Unit)) {
                is Result.Success -> _pastLaunchesState.post(State.Success(result.data))
                is Result.Error -> _pastLaunchesState.post(State.Error(result.failure))
            }
        }
    }
}