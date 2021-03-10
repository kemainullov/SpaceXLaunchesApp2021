package com.kamil.ainullov.spacexlaunchesapp.di

import com.kamil.ainullov.domain.repository.LaunchRepository
import com.kamil.ainullov.domain.repository.PastLaunchesRepository
import com.kamil.ainullov.domain.repository.UpcomingLaunchesRepository
import com.kamil.ainullov.domain.usecase.GetLaunchUseCase
import com.kamil.ainullov.domain.usecase.GetPastLaunchesUseCase
import com.kamil.ainullov.domain.usecase.GetUpcomingLaunchesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
//
//@Module
//@InstallIn(ActivityComponent::class)
//object UseCaseModule {
//
//    @Provides
//    fun provideGetLaunchUseCase(
//        launchRepository: LaunchRepository
//    ): GetLaunchUseCase {
//        return GetLaunchUseCase(launchRepository)
//    }
//
//    @Provides
//    fun provideGetPastLaunchesUseCase(
//        pastLaunchesRepository: PastLaunchesRepository
//    ): GetPastLaunchesUseCase {
//        return GetPastLaunchesUseCase(pastLaunchesRepository)
//    }
//
//    @Provides
//    fun provideGetUpcomingLaunchesUseCase(
//        upcomingLaunchesRepository: UpcomingLaunchesRepository
//    ): GetUpcomingLaunchesUseCase {
//        return GetUpcomingLaunchesUseCase(upcomingLaunchesRepository)
//    }
//}