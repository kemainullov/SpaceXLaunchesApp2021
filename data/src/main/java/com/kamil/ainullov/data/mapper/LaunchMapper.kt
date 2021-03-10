package com.kamil.ainullov.data.mapper

import com.kamil.ainullov.data.model.LaunchData
import com.kamil.ainullov.data.utils.ext.parseDate
import com.kamil.ainullov.domain.entity.LaunchEntity
import javax.inject.Inject

class LaunchMapper @Inject constructor() : Mapper<LaunchData, LaunchEntity> {

    override fun mapFrom(from: LaunchData): LaunchEntity {
        return LaunchEntity(
            id = from.id,
            icon = from.links.patch.small,
            image = from.links.flickr.original.first(),
            name = from.name,
            details = from.details,
            success = from.success,
            date = from.date_unix,
            dateFormatted = from.date_unix.parseDate(),
            upcoming = from.upcoming,
            webcast = from.links.webcast,
            article = from.links.article,
            wikipedia = from.links.wikipedia
        )
    }

}