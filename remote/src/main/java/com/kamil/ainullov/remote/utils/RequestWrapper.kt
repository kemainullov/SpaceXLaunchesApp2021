package com.kamil.ainullov.remote.utils

import retrofit2.Response
import com.kamil.ainullov.domain.core.Result
import com.kamil.ainullov.remote.utils.ext.parseLocalError
import com.kamil.ainullov.remote.utils.ext.parseServerError
import java.lang.Exception

suspend fun <T : Any> executeRequest(request: suspend () -> Response<T>): Result<T> {
    return try {
        val response = request()
        if (response.isSuccessful) {
            Result.Success(response.body()!!)
        } else {
            Result.Error(response.parseServerError())
        }
    } catch (e: Exception) {
        Result.Error(e.parseLocalError())
    }

}
