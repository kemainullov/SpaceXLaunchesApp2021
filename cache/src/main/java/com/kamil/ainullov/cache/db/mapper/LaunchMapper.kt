package com.kamil.ainullov.cache.db.mapper

import com.kamil.ainullov.cache.db.model.LaunchModel
import com.kamil.ainullov.domain.core.Mapper
import com.kamil.ainullov.domain.entity.LaunchEntity
import javax.inject.Inject

class LaunchMapper @Inject constructor() : Mapper<LaunchModel, LaunchEntity> {

    override fun mapFrom(from: LaunchModel): LaunchEntity {
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

    override fun mapTo(from: LaunchEntity): LaunchModel {
        return LaunchModel(
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