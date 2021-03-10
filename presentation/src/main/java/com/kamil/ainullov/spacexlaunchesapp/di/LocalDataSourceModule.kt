package com.kamil.ainullov.spacexlaunchesapp.di

import com.kamil.ainullov.data.local.source.LaunchesLocalDataSourceImpl
import com.kamil.ainullov.data.source.LaunchesLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object LocalDataSourceModule {

    @Provides
    fun provideLaunchesLocalDataSource(): LaunchesLocalDataSource {
        return LaunchesLocalDataSourceImpl() // TODO!
    }

}