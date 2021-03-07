package com.kamil.ainullov.domain.entity

data class LaunchEntity(
    val id: String,
    val icon: String,
    val image: String,
    val name: String,
    val details: String,
    val success: Boolean,
    val data: Long,
    val dataFormatted: String,
    val upcoming: Boolean,
    val webcast: String,
    val article: String,
    val wikipedia: String
)
