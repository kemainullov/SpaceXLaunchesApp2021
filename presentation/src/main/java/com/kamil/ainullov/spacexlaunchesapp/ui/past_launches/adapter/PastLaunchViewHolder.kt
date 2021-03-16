package com.kamil.ainullov.spacexlaunchesapp.ui.past_launches.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kamil.ainullov.domain.entity.SimpleLaunchEntity
import com.kamil.ainullov.spacexlaunchesapp.databinding.ItemPastLaunchBinding

class PastLaunchViewHolder(private val itemBinding: ItemPastLaunchBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(launch: SimpleLaunchEntity, onClickListener: (SimpleLaunchEntity) -> Unit) {
        launch.icon?.let { itemBinding.ivLaunchIcon.load(it) }
        itemBinding.tvName.text = launch.name
        itemBinding.tvDetails.text = launch.details
        itemBinding.tvDate.text = launch.dateFormatted
        itemBinding.root.setOnClickListener { onClickListener(launch) }
    }
}