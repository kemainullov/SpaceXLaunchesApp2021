package com.kamil.ainullov.spacexlaunchesapp.ui.upcoming_launches

import com.kamil.ainullov.domain.usecase.GetUpcomingLaunchesUseCase
import com.kamil.ainullov.spacexlaunchesapp.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UpcomingLaunchesViewModel @Inject constructor(
    private val getUpcomingLaunchesUseCase: GetUpcomingLaunchesUseCase
) : BaseViewModel() {
}