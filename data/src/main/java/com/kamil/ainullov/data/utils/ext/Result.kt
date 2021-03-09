package com.kamil.ainullov.data.utils.ext

import com.kamil.ainullov.data.mapper.Mapper
import com.kamil.ainullov.domain.core.Result

fun <T, E> Result<List<T>>.mapResultList(mapper: Mapper<T, E>): Result<List<E>> {
    return if (this is Result.Success) {
        Result.Success(data.map { mapper.mapFrom(it) })
    } else Result.Error((this as Result.Error).failure)
}

fun <T, E> Result<T>.mapResult(mapper: Mapper<T, E>): Result<E> {
    return if (this is Result.Success) {
        Result.Success(mapper.mapFrom(data))
    } else Result.Error((this as Result.Error).failure)
}
