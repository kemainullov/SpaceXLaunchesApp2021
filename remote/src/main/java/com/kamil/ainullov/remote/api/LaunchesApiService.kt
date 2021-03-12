package com.kamil.ainullov.remote.api

import com.kamil.ainullov.remote.model.LaunchData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface LaunchesApiService {

    @GET("launches/past")
    suspend fun getPastLaunches(): Response<List<LaunchData>>

    @GET("launches/upcoming")
    suspend fun getUpcomingLaunches(): Response<List<LaunchData>>

    @GET("launches/{id}")
    suspend fun getLaunch(@Path("id") id: String): Response<LaunchData>

}