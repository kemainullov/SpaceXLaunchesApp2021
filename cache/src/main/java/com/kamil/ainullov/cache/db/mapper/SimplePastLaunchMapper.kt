package com.kamil.ainullov.cache.db.mapper

import com.kamil.ainullov.cache.db.model.SimplePastLaunchModel
import com.kamil.ainullov.domain.core.Mapper
import com.kamil.ainullov.domain.entity.SimpleLaunchEntity
import javax.inject.Inject

class SimplePastLaunchMapper @Inject constructor() : Mapper<SimplePastLaunchModel, SimpleLaunchEntity> {

    override fun mapFrom(from: SimplePastLaunchModel): SimpleLaunchEntity {
        return SimpleLaunchEntity(
            id = from.id,
            icon = from.icon,
            name = from.name,
            details = from.details,
            success = from.success,
            date = from.date,
            dateFormatted = from.dateFormatted
        )
    }

    override fun mapTo(from: SimpleLaunchEntity): SimplePastLaunchModel {
        return SimplePastLaunchModel(
            id = from.id,
            icon = from.icon,
            name = from.name,
            details = from.details,
            success = from.success,
            date = from.date,
            dateFormatted = from.dateFormatted
        )
    }

}