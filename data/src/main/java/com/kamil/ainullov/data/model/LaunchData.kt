package com.kamil.ainullov.data.model

data class LaunchData(
    val id: String,
    val name: String,
    val links: LinksData,
    val details: String,
    val date_unix: Long,
    val upcoming: Boolean,
    val success: Boolean
)
