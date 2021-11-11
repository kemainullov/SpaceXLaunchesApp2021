package com.kamil.ainullov.spacexlaunchesapp.base

import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController

abstract class BaseActivity : AppCompatActivity() {

    abstract fun getNavControllerResId(): Int

    open fun enableBackButton() = supportActionBar?.apply {
        setHomeButtonEnabled(true)
        setDisplayHomeAsUpEnabled(true)
        setDisplayShowHomeEnabled(true)
    }

    open fun disableBackButton() = supportActionBar?.apply {
        setHomeButtonEnabled(false)
        setDisplayHomeAsUpEnabled(false)
        setDisplayShowHomeEnabled(false)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == android.R.id.home) {
            if (!findNavController(getNavControllerResId()).navigateUp()) {
                finish()
            }
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }
}