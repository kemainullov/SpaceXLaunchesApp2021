package com.kamil.ainullov.cache.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "upcoming_launch")
data class UpcomingLaunchModel(
    @PrimaryKey val id: String,
    val icon: String?,
    val image: String?,
    val name: String?,
    val details: String?,
    val success: Boolean?,
    val date: Long?,
    val dateFormatted: String?,
    val upcoming: Boolean?,
    val webcast: String?,
    val article: String?,
    val wikipedia: String?
)