package com.kamil.ainullov.spacexlaunchesapp.ui.past_launches

import com.kamil.ainullov.domain.usecase.GetPastLaunchesUseCase
import com.kamil.ainullov.spacexlaunchesapp.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PastLaunchesViewModel @Inject constructor(
    private val getPastLaunchesUseCase: GetPastLaunchesUseCase
): BaseViewModel() {
}