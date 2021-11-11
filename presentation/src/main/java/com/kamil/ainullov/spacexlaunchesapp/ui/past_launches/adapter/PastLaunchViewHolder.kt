package com.kamil.ainullov.spacexlaunchesapp.ui.past_launches.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kamil.ainullov.domain.entity.SimpleLaunchEntity
import com.kamil.ainullov.spacexlaunchesapp.R
import com.kamil.ainullov.spacexlaunchesapp.databinding.ItemPastLaunchBinding

class PastLaunchViewHolder(private val itemBinding: ItemPastLaunchBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(launch: SimpleLaunchEntity, onClickListener: (SimpleLaunchEntity) -> Unit) =
        itemBinding.apply {
            launch.icon?.let {
                ivLaunchIcon.load(it) { error(R.drawable.ic_rocket) }
            }
            tvName.text = launch.name
            tvDetails.text = launch.details
            tvDate.text = launch.dateFormatted
            root.setOnClickListener { onClickListener(launch) }
        }
}