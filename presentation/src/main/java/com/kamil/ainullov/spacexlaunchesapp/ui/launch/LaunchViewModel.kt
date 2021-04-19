package com.kamil.ainullov.spacexlaunchesapp.ui.launch

import androidx.lifecycle.viewModelScope
import com.kamil.ainullov.domain.core.Result
import com.kamil.ainullov.domain.entity.LaunchEntity
import com.kamil.ainullov.domain.usecase.GetLaunchUseCase
import com.kamil.ainullov.spacexlaunchesapp.base.BaseViewModel
import com.kamil.ainullov.spacexlaunchesapp.utils.state.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchViewModel @Inject constructor(
    private val getLaunchUseCase: GetLaunchUseCase
) : BaseViewModel() {

    private val _launchState = MutableStateFlow<State<LaunchEntity>>(State.Default)
    val launchState: StateFlow<State<LaunchEntity>> get() = _launchState

    fun getLaunch(launchId: String) {
        _launchState.value = State.Loading
        viewModelScope.launch {
            when (val result = getLaunchUseCase.invoke(launchId)) {
                is Result.Success -> _launchState.value = State.Success(result.data)
                is Result.Error -> _launchState.value = State.Error(result.failure)
            }
        }
    }
}