package com.kamil.ainullov.remote.mapper

import com.kamil.ainullov.remote.model.LaunchData
import com.kamil.ainullov.domain.core.Mapper
import com.kamil.ainullov.domain.entity.LaunchEntity
import com.kamil.ainullov.remote.utils.ext.parseDate
import javax.inject.Inject

class LaunchMapper @Inject constructor() : Mapper<LaunchData, LaunchEntity> {

    override fun mapFrom(from: LaunchData): LaunchEntity {
        return LaunchEntity(
            id = from.id,
            icon = from.links?.patch?.small,
            image = from.links?.flickr?.original?.firstOrNull(),
            name = from.name,
            details = from.details,
            success = from.success,
            date = from.date_unix,
            dateFormatted = from.date_unix?.parseDate(),
            upcoming = from.upcoming,
            webcast = from.links?.webcast,
            article = from.links?.article,
            wikipedia = from.links?.wikipedia
        )
    }

    override fun mapTo(from: LaunchEntity): LaunchData {
        return LaunchData(
            id = from.id,
            name = from.name,
            links = null,
            details = from.details,
            date_unix = from.date,
            upcoming = from.upcoming,
            success = from.success
        )
    }

}