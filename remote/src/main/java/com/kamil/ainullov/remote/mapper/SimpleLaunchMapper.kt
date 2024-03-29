package com.kamil.ainullov.remote.mapper

import com.kamil.ainullov.remote.model.LaunchData
import com.kamil.ainullov.domain.core.Mapper
import com.kamil.ainullov.domain.entity.SimpleLaunchEntity
import com.kamil.ainullov.remote.model.FlickrData
import com.kamil.ainullov.remote.model.LinksData
import com.kamil.ainullov.remote.model.PatchData
import com.kamil.ainullov.remote.utils.ext.parseDate
import javax.inject.Inject

class SimpleLaunchMapper @Inject constructor() : Mapper<LaunchData, SimpleLaunchEntity> {

    override fun mapFrom(from: LaunchData): SimpleLaunchEntity {
        return SimpleLaunchEntity(
            id = from.id,
            icon = from.links?.patch?.small,
            name = from.name,
            details = from.details,
            success = from.success,
            date = from.date_unix,
            dateFormatted = from.date_unix?.parseDate()
        )
    }

    override fun mapTo(from: SimpleLaunchEntity): LaunchData {
        return LaunchData(
            id = from.id,
            name = from.name,
            links = null,
            details = from.details,
            date_unix = from.date,
            upcoming = null,
            success = from.success
        )
    }

}