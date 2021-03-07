package com.kamil.ainullov.data.remote.api

import com.kamil.ainullov.data.model.LaunchData
import retrofit2.http.GET
import retrofit2.http.Path

interface LaunchesApiService {

    @GET("launches/past")
    suspend fun getPastLaunches(): List<LaunchData>

    @GET("launches/upcoming")
    suspend fun getUpcomingLaunches(): List<LaunchData>

    @GET("launches/{id}")
    suspend fun getLaunch(@Path("id") id: String): LaunchData

}