package com.kamil.ainullov.data.mapper

import com.kamil.ainullov.data.model.LaunchData
import com.kamil.ainullov.data.utils.ext.parseDate
import com.kamil.ainullov.domain.entity.SimpleLaunchEntity
import javax.inject.Inject

class SimpleLaunchMapper @Inject constructor() : Mapper<LaunchData, SimpleLaunchEntity> {

    override fun mapFrom(from: LaunchData): SimpleLaunchEntity {
        return SimpleLaunchEntity(
            id = from.id,
            icon = from.links.patch.small,
            name = from.name,
            details = from.details,
            success = from.success,
            date = from.date_unix,
            dateFormatted = from.date_unix.parseDate()
        )
    }

}