package com.kamil.ainullov.spacexlaunchesapp.ui.launch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kamil.ainullov.domain.core.Result
import com.kamil.ainullov.domain.entity.LaunchEntity
import com.kamil.ainullov.domain.usecase.GetLaunchUseCase
import com.kamil.ainullov.spacexlaunchesapp.base.BaseViewModel
import com.kamil.ainullov.spacexlaunchesapp.utils.ext.default
import com.kamil.ainullov.spacexlaunchesapp.utils.ext.post
import com.kamil.ainullov.spacexlaunchesapp.utils.ext.set
import com.kamil.ainullov.spacexlaunchesapp.utils.state.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchViewModel @Inject constructor(
    private val getLaunchUseCase: GetLaunchUseCase
) : BaseViewModel() {

    private val _launchState =
        MutableLiveData<State<LaunchEntity>>().default(initialValue = State.Default)
    val launchState: LiveData<State<LaunchEntity>> = _launchState

    fun getLaunch(launchId: String) {
        _launchState.set(newValue = State.Loading)
        viewModelScope.launch {
            when (val result = getLaunchUseCase.invoke(launchId)) {
                is Result.Success -> _launchState.post(State.Success(result.data))
                is Result.Error -> _launchState.post(State.Error(result.failure))
            }
        }
    }
}