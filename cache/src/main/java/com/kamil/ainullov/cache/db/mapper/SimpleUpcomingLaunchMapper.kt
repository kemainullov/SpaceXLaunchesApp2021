package com.kamil.ainullov.cache.db.mapper

import com.kamil.ainullov.cache.db.model.SimpleUpcomingLaunchModel
import com.kamil.ainullov.domain.core.Mapper
import com.kamil.ainullov.domain.entity.SimpleLaunchEntity
import javax.inject.Inject

class SimpleUpcomingLaunchMapper @Inject constructor() : Mapper<SimpleUpcomingLaunchModel, SimpleLaunchEntity> {

    override fun mapFrom(from: SimpleUpcomingLaunchModel): SimpleLaunchEntity {
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

    override fun mapTo(from: SimpleLaunchEntity): SimpleUpcomingLaunchModel {
        return SimpleUpcomingLaunchModel(
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