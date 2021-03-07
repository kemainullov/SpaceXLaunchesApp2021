package com.kamil.ainullov.domain.core

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
    data class ErrorServer(val errorCode: Int, val message: String) : Result<Nothing>()
}