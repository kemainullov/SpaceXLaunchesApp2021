package com.kamil.ainullov.spacexlaunchesapp.utils.ext

import android.view.View

fun View.setVisible(isVisible: Boolean) {
    if (isVisible) this.visibility = View.VISIBLE else View.GONE
}