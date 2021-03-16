package com.kamil.ainullov.spacexlaunchesapp.utils.ext

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.kamil.ainullov.spacexlaunchesapp.R

fun String?.openWeb(context: Context) {
    this?.let {
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(it)
        try {
            context.startActivity(i)
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(context, context.getString(R.string.incorrect_link), Toast.LENGTH_SHORT).show()
        }
    }
}