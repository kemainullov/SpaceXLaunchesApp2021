package com.kamil.ainullov.spacexlaunchesapp.ui.upcoming_launches

import android.os.Bundle
import android.view.*
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.kamil.ainullov.spacexlaunchesapp.R
import com.kamil.ainullov.spacexlaunchesapp.base.BaseFragment
import com.kamil.ainullov.spacexlaunchesapp.databinding.FragmentUpcomingLaunchesBinding
import com.kamil.ainullov.spacexlaunchesapp.ui.upcoming_launches.adapter.UpcomingLaunchesAdapter
import com.kamil.ainullov.spacexlaunchesapp.utils.state.State
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UpcomingLaunchesFragment : BaseFragment() {

    private var _binding: FragmentUpcomingLaunchesBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: UpcomingLaunchesAdapter

    private val viewModel: UpcomingLaunchesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUpcomingLaunchesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setActionBarData(getString(R.string.upcoming_launches), true)
        initAdapter()
        observeStates()
        viewModel.getUpcomingLaunches()
    }

    private fun observeStates() {
        lifecycleScope.launch {
            viewModel.upcomingLaunchesState.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect { state ->
                    when (state) {
                        is State.Default -> {
                        }
                        is State.Loading -> {
                            binding.progress.root.visibility = View.VISIBLE
                        }
                        is State.Success -> {
                            binding.progress.root.visibility = View.GONE
                            adapter.updateData(state.data)
                        }
                        is State.Error -> {
                            binding.progress.root.visibility = View.GONE
                            handleError(state) { viewModel.getUpcomingLaunches() }
                        }
                    }
                }
        }
    }

    private fun initAdapter() {
        adapter = UpcomingLaunchesAdapter(mutableListOf())
        binding.rvLaunches.layoutManager = LinearLayoutManager(requireContext())
        binding.rvLaunches.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}