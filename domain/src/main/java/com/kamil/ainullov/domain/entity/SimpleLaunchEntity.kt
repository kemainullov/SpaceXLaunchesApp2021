package com.kamil.ainullov.domain.entity

data class SimpleLaunchEntity(
    val id: String,
    val icon: String?,
    val name: String?,
    val details: String?,
    val success: Boolean?,
    val date: Long?,
    val dateFormatted: String?
)
