package com.kamil.ainullov.cache.di

import com.kamil.ainullov.cache.source.LaunchesLocalDataSourceImpl
import com.kamil.ainullov.data.source.LaunchesLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

    @Binds
    abstract fun provideLaunchesLocalDataSource(launchesLocalDataSourceImpl: LaunchesLocalDataSourceImpl): LaunchesLocalDataSource

}