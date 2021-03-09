package com.kamil.ainullov.spacexlaunchesapp.ui.launch

import com.kamil.ainullov.domain.usecase.GetLaunchUseCase
import com.kamil.ainullov.spacexlaunchesapp.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LaunchViewModel @Inject constructor(
    private val getLaunchUseCase: GetLaunchUseCase
): BaseViewModel() {
}