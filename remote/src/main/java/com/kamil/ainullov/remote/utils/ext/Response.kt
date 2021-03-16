package com.kamil.ainullov.remote.utils.ext

import com.kamil.ainullov.domain.core.Failure
import retrofit2.Response

fun <T> Response<T>.parseServerError(): Failure {

//    // Handling the base server response when it appears
//    var errorMessage = ""
//    errorBody()?.string()?.let {
//        val message = Gson().fromJson(it, BaseResponse::class.java).message
//        if (message != null) {
//            errorMessage = message
//        }
//    }
    if (body() == null)
        return Failure.ResponseIsNullError

    return when (code()) {
        401 -> Failure.UnauthorizedError
        403 -> Failure.UnknownLoginError
        500 -> Failure.ServerUnknownError
        else -> Failure.ServerError
    }
}