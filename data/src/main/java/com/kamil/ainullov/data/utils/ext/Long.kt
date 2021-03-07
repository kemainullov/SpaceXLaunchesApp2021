package com.kamil.ainullov.data.utils.ext

import java.text.SimpleDateFormat
import java.util.*

fun Long.parseDate(pattern: String = "dd.MM.yyyy", locale: String = "ru"): String {
    val format = SimpleDateFormat(pattern, Locale(locale))
    return format.format(this)
}