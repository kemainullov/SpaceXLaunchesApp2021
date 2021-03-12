package com.kamil.ainullov.spacexlaunchesapp.di

import com.kamil.ainullov.remote.source.LaunchesRemoteDataSourceImpl
import com.kamil.ainullov.data.source.LaunchesRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun provideLaunchesRemoteDataSource(launchesRemoteDataSourceImpl: LaunchesRemoteDataSourceImpl): LaunchesRemoteDataSource
}