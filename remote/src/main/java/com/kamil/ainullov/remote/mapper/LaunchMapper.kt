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