package com.kamil.ainullov.spacexlaunchesapp.ui.past_launches.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kamil.ainullov.domain.entity.SimpleLaunchEntity
import com.kamil.ainullov.spacexlaunchesapp.databinding.ItemPastLaunchBinding

class PastLaunchesAdapter(
    private val list: MutableList<SimpleLaunchEntity>,
    private val onClickListener: (SimpleLaunchEntity) -> Unit
) : RecyclerView.Adapter<PastLaunchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PastLaunchViewHolder {
        val itemBinding =
            ItemPastLaunchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PastLaunchViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = list.size

    fun updateData(list: List<SimpleLaunchEntity>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: PastLaunchViewHolder, position: Int) {
        holder.bind(list[position], onClickListener)
    }
}