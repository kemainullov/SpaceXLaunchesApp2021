package com.kamil.ainullov.spacexlaunchesapp.ui.past_launches

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.kamil.ainullov.spacexlaunchesapp.R
import com.kamil.ainullov.spacexlaunchesapp.base.BaseFragment
import com.kamil.ainullov.spacexlaunchesapp.databinding.FragmentPastLaunchesBinding
import com.kamil.ainullov.spacexlaunchesapp.utils.state.State
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PastLaunchesFragment : BaseFragment() {

    private var _binding: FragmentPastLaunchesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PastLaunchesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPastLaunchesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setActionBarData(getString(R.string.past_launches), true)
        observeStates()
        viewModel.getPastLaunches()
    }

    private fun observeStates() {
        viewModel.pastLaunchesState.observe(viewLifecycleOwner, { state ->
            when (state) {
                is State.Default -> {
                }
                is State.Loading -> {
                    binding.pbLoading.visibility = View.VISIBLE
                }
                is State.Success -> {
                    binding.pbLoading.visibility = View.GONE
                    state.data // can use
                }
                is State.Error -> {
                }
            }
        })
    }

}