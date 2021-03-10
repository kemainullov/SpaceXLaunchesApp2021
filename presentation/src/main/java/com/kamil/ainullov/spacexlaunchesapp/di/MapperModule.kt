package com.kamil.ainullov.spacexlaunchesapp.di

import com.kamil.ainullov.data.local.source.LaunchesLocalDataSourceImpl
import com.kamil.ainullov.data.mapper.LaunchMapper
import com.kamil.ainullov.data.mapper.SimpleLaunchMapper
import com.kamil.ainullov.data.source.LaunchesLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object MapperModule {

    @Provides
    @Singleton
    fun provideLaunchMapper(): LaunchMapper {
        return LaunchMapper()
    }

    @Provides
    @Singleton
    fun provideSimpleLaunchMapper(): SimpleLaunchMapper {
        return SimpleLaunchMapper()
    }
}