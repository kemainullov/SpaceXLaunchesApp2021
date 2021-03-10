package com.kamil.ainullov.spacexlaunchesapp.di

import com.kamil.ainullov.data.local.source.LaunchesLocalDataSourceImpl
import com.kamil.ainullov.data.remote.source.LaunchesRemoteDataSourceImpl
import com.kamil.ainullov.data.source.LaunchesLocalDataSource
import com.kamil.ainullov.data.source.LaunchesRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class LocalDataSourceModule {

    @Binds
    abstract fun provideLaunchesLocalDataSource(launchesLocalDataSourceImpl: LaunchesLocalDataSourceImpl): LaunchesLocalDataSource
//    @Provides
//    fun provideLaunchesLocalDataSource(): LaunchesLocalDataSource {
//        return LaunchesLocalDataSourceImpl() // TODO!
//    }

}