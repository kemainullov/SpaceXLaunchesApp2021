package com.kamil.ainullov.cache.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "simple_upcoming_launch")
data class SimpleUpcomingLaunchModel(
    @PrimaryKey val id: String,
    val icon: String?,
    val name: String?,
    val details: String?,
    val success: Boolean?,
    val date: Long?,
    val dateFormatted: String?
)
