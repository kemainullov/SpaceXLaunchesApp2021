package com.kamil.ainullov.spacexlaunchesapp.ui.upcoming_launches.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kamil.ainullov.domain.entity.SimpleLaunchEntity
import com.kamil.ainullov.spacexlaunchesapp.R
import com.kamil.ainullov.spacexlaunchesapp.databinding.ItemUpcomingLaunchBinding

class UpcomingLaunchViewHolder(private val itemBinding: ItemUpcomingLaunchBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(launch: SimpleLaunchEntity) {
        launch.icon?.let {
            itemBinding.ivLaunchIcon.load(it) { error(R.drawable.ic_rocket) }
        }
        itemBinding.tvName.text = launch.name
        itemBinding.tvDate.text = launch.dateFormatted
    }
}