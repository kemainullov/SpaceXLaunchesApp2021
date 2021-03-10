package com.kamil.ainullov.spacexlaunchesapp.di

import com.kamil.ainullov.data.repository.LaunchRepositoryImpl
import com.kamil.ainullov.data.repository.PastLaunchesRepositoryImpl
import com.kamil.ainullov.data.repository.UpcomingLaunchesRepositoryImpl
import com.kamil.ainullov.data.source.LaunchesLocalDataSource
import com.kamil.ainullov.data.source.LaunchesRemoteDataSource
import com.kamil.ainullov.domain.repository.LaunchRepository
import com.kamil.ainullov.domain.repository.PastLaunchesRepository
import com.kamil.ainullov.domain.repository.UpcomingLaunchesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object RepositoryModule {

    @Provides
    fun provideLaunchRepository(
        launchesRemoteDataSource: LaunchesRemoteDataSource,
        launchesLocalDataSource: LaunchesLocalDataSource
    ): LaunchRepository {
        return LaunchRepositoryImpl(launchesRemoteDataSource, launchesLocalDataSource)
    }

    @Provides
    fun providePastLaunchesRepository(
        launchesRemoteDataSource: LaunchesRemoteDataSource,
        launchesLocalDataSource: LaunchesLocalDataSource
    ): PastLaunchesRepository {
        return PastLaunchesRepositoryImpl(launchesRemoteDataSource, launchesLocalDataSource)
    }

    @Provides
    fun provideUpcomingLaunchesRepository(
        launchesRemoteDataSource: LaunchesRemoteDataSource,
        launchesLocalDataSource: LaunchesLocalDataSource
    ): UpcomingLaunchesRepository {
        return UpcomingLaunchesRepositoryImpl(launchesRemoteDataSource, launchesLocalDataSource)
    }

}