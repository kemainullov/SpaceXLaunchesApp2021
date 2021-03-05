package com.kamil.ainullov.spacexlaunchesapp.ui.activity

import android.os.Bundle
import com.kamil.ainullov.spacexlaunchesapp.R
import com.kamil.ainullov.spacexlaunchesapp.base.BaseActivity
import com.kamil.ainullov.spacexlaunchesapp.databinding.ActivitySingleBinding

class SingleActivity : BaseActivity() {

    override fun getNavControllerResId(): Int = R.id.nav_host_fragment

    private lateinit var binding: ActivitySingleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingleBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}