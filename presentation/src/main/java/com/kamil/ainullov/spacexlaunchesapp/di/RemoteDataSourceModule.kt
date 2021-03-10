package com.kamil.ainullov.spacexlaunchesapp.di

import com.kamil.ainullov.data.mapper.LaunchMapper
import com.kamil.ainullov.data.mapper.SimpleLaunchMapper
import com.kamil.ainullov.data.remote.api.LaunchesApiService
import com.kamil.ainullov.data.remote.source.LaunchesRemoteDataSourceImpl
import com.kamil.ainullov.data.repository.LaunchRepositoryImpl
import com.kamil.ainullov.data.source.LaunchesRemoteDataSource
import com.kamil.ainullov.domain.repository.LaunchRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun provideLaunchesRemoteDataSource(launchesRemoteDataSourceImpl: LaunchesRemoteDataSourceImpl): LaunchesRemoteDataSource
//    @Provides
//    fun provideLaunchesRemoteDataSource(
//        launchesApiService: LaunchesApiService,
//        launchesMapper: LaunchMapper,
//        simpleLaunchesMapper: SimpleLaunchMapper
//    ): LaunchesRemoteDataSource {
//        return LaunchesRemoteDataSourceImpl(
//            launchesApiService,
//            launchesMapper,
//            simpleLaunchesMapper
//        )
//    }
}