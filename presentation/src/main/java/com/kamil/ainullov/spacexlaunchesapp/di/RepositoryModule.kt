package com.kamil.ainullov.spacexlaunchesapp.di

import com.kamil.ainullov.data.repository.LaunchRepositoryImpl
import com.kamil.ainullov.data.repository.PastLaunchesRepositoryImpl
import com.kamil.ainullov.data.repository.UpcomingLaunchesRepositoryImpl
import com.kamil.ainullov.domain.repository.LaunchRepository
import com.kamil.ainullov.domain.repository.PastLaunchesRepository
import com.kamil.ainullov.domain.repository.UpcomingLaunchesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideLaunchRepository(launchRepositoryImpl: LaunchRepositoryImpl): LaunchRepository

    @Binds
    abstract fun providePastLaunchesRepository(pastLaunchesRepositoryImpl: PastLaunchesRepositoryImpl): PastLaunchesRepository

    @Binds
    abstract fun provideUpcomingLaunchesRepository(upcomingLaunchesRepositoryImpl: UpcomingLaunchesRepositoryImpl): UpcomingLaunchesRepository

}