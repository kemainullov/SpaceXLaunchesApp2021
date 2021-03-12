package com.kamil.ainullov.cache.db.mapper

import com.kamil.ainullov.cache.db.model.PastLaunchModel
import com.kamil.ainullov.domain.core.Mapper
import com.kamil.ainullov.domain.entity.LaunchEntity
import javax.inject.Inject

class PastLaunchMapper @Inject constructor() : Mapper<PastLaunchModel, LaunchEntity> {

    override fun mapFrom(from: PastLaunchModel): LaunchEntity {
        return LaunchEntity(
            id = from.id,
            icon = from.icon,
            image = from.image,
            name = from.name,
            details = from.details,
            success = from.success,
            date = from.date,
            dateFormatted = from.dateFormatted,
            upcoming = from.upcoming,
            webcast = from.webcast,
            article = from.article,
            wikipedia = from.wikipedia
        )
    }

    override fun mapTo(from: LaunchEntity): PastLaunchModel {
        return PastLaunchModel(
            id = from.id,
            icon = from.icon,
            image = from.image,
            name = from.name,
            details = from.details,
            success = from.success,
            date = from.date,
            dateFormatted = from.dateFormatted,
            upcoming = from.upcoming,
            webcast = from.webcast,
            article = from.article,
            wikipedia = from.wikipedia
        )
    }

}