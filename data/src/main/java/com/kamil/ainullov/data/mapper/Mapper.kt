package com.kamil.ainullov.data.mapper

interface Mapper<E, D> {

    fun mapFrom(from: E): D

}
