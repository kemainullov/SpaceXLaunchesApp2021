package com.kamil.ainullov.spacexlaunchesapp.ui.upcoming_launches.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kamil.ainullov.domain.entity.SimpleLaunchEntity
import com.kamil.ainullov.spacexlaunchesapp.databinding.ItemUpcomingLaunchBinding

class UpcomingLaunchesAdapter(
    private val list: MutableList<SimpleLaunchEntity>
) : RecyclerView.Adapter<UpcomingLaunchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingLaunchViewHolder {
        val itemBinding =
            ItemUpcomingLaunchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UpcomingLaunchViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = list.size

    fun updateData(list: List<SimpleLaunchEntity>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: UpcomingLaunchViewHolder, position: Int) {
        holder.bind(list[position])
    }
}