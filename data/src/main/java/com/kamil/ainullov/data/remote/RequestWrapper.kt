package com.kamil.ainullov.data.remote

import com.kamil.ainullov.domain.core.Failure
import retrofit2.Response
import com.kamil.ainullov.domain.core.Result
import java.lang.Exception
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException
import javax.net.ssl.SSLException

suspend fun <T : Any> executeRequest(request: suspend () -> Response<T>): Result<T> {
    return try {
        val response = request()
        if (response.isSuccessful) {
            Result.Success(response.body()!!)
        } else {
            Result.Error(response.parseServerError())
        }
    } catch (e: Exception) {
        Result.Error(parseLocalError(e))
    }

}

private fun parseLocalError(e: Exception): Failure {
    return when (e) {
        is UnknownHostException -> Failure.NetworkConnectionError
        is TimeoutException -> Failure.TimeoutError
        is SSLException -> Failure.SSLError
        else -> Failure.NetworkConnectionError
    }
}

private fun <T> Response<T>.parseServerError(): Failure {

//    // Handling the base server response when it appears
//    var errorMessage = ""
//    errorBody()?.string()?.let {
//        val message = Gson().fromJson(it, BaseResponse::class.java).message
//        if (message != null) {
//            errorMessage = message
//        }
//    }

    return when (code()) {
        401 -> Failure.UnauthorizedError
        403 -> Failure.UnknownLoginError
        500 -> Failure.ServerUnknownError
        else -> Failure.ServerError
    }
}
