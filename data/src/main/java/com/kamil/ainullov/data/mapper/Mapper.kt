package com.kamil.ainullov.data.mapper

interface Mapper<E, D> {

    fun mapTo(from: D): E

}
