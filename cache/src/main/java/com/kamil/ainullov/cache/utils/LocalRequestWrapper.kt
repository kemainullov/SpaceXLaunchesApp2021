package com.kamil.ainullov.cache.utils

import com.kamil.ainullov.domain.core.Result
import com.kamil.ainullov.domain.utils.ext.parseLocalError
import java.lang.Exception

suspend fun <T : Any> executeLocalRequest(request: suspend () -> T): Result<T> {
    return try {
        val response = request()
        Result.Success(response)
    } catch (e: Exception) {
        Result.Error(e.parseLocalError())
    }
}