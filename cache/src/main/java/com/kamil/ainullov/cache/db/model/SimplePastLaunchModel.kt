package com.kamil.ainullov.cache.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "simple_past_launch")
data class SimplePastLaunchModel(
    @PrimaryKey val id: String,
    val icon: String?,
    val name: String?,
    val details: String?,
    val success: Boolean?,
    val date: Long?,
    val dateFormatted: String?
)
