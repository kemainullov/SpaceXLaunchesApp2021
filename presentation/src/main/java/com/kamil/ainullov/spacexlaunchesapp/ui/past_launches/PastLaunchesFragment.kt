package com.kamil.ainullov.spacexlaunchesapp.ui.past_launches

import android.os.Bundle
import android.view.*
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.kamil.ainullov.spacexlaunchesapp.R
import com.kamil.ainullov.spacexlaunchesapp.base.BaseFragment
import com.kamil.ainullov.spacexlaunchesapp.databinding.FragmentPastLaunchesBinding
import com.kamil.ainullov.spacexlaunchesapp.ui.past_launches.adapter.PastLaunchesAdapter
import com.kamil.ainullov.spacexlaunchesapp.utils.state.State
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PastLaunchesFragment : BaseFragment() {

    private var _binding: FragmentPastLaunchesBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: PastLaunchesAdapter

    private val viewModel: PastLaunchesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        viewModel.getPastLaunches()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPastLaunchesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setActionBarData(getString(R.string.past_launches))
        initAdapter()
        observeStates()
    }

    private fun observeStates() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.pastLaunchesState.collect { state ->
                    when (state) {
                        is State.Default -> {
                        }
                        is State.Loading -> {
                            binding.progress.root.visibility = View.VISIBLE
                        }
                        is State.Success -> {
                            binding.progress.root.visibility = View.GONE
                            adapter.updateData(state.data.reversed())
                        }
                        is State.Error -> {
                            binding.progress.root.visibility = View.GONE
                            handleError(state) { viewModel.getPastLaunches() }
                        }
                    }
                }
            }
        }
    }

    private fun initAdapter() {
        adapter = PastLaunchesAdapter(mutableListOf()) { launch ->
            onGoToLaunch(launch.id)
        }
        binding.rvLaunches.layoutManager = LinearLayoutManager(requireContext())
        binding.rvLaunches.adapter = adapter
    }

    private fun onGoToLaunch(launchId: String) {
        val action = PastLaunchesFragmentDirections.actionToLaunchFragment(launchId)
        findNavController().navigate(action)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) =
        inflater.inflate(R.menu.menu_past_launches, menu)

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        NavigationUI.onNavDestinationSelected(item, findNavController())
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}