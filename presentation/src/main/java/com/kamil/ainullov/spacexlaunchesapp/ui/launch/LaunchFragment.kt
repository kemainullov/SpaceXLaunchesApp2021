package com.kamil.ainullov.spacexlaunchesapp.ui.launch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import coil.load
import com.kamil.ainullov.domain.entity.LaunchEntity
import com.kamil.ainullov.spacexlaunchesapp.R
import com.kamil.ainullov.spacexlaunchesapp.base.BaseFragment
import com.kamil.ainullov.spacexlaunchesapp.databinding.FragmentLaunchBinding
import com.kamil.ainullov.spacexlaunchesapp.utils.ext.openWeb
import com.kamil.ainullov.spacexlaunchesapp.utils.state.State
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LaunchFragment : BaseFragment() {

    private var _binding: FragmentLaunchBinding? = null
    private val binding get() = _binding!!
    private val args: LaunchFragmentArgs by navArgs()

    private val viewModel: LaunchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLaunchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setActionBarData(getString(R.string.launch), true)
        observeStates()
        viewModel.getLaunch(args.launchId)
    }

    private fun observeStates() {
        lifecycleScope.launch {
            viewModel.launchState.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect { state ->
                    when (state) {
                        is State.Default -> {}
                        is State.Loading -> binding.progress.root.visibility = View.VISIBLE
                        is State.Success -> setLaunchData(state.data)
                        is State.Error -> {
                            binding.clParent.visibility = View.GONE
                            binding.progress.root.visibility = View.GONE
                            handleError(state) { viewModel.getLaunch(args.launchId) }
                        }
                    }
                }
        }
    }

    private fun setLaunchData(launch: LaunchEntity) {
        if (!launch.image.isNullOrBlank()) {
            binding.ivLaunch.load(launch.image) {
                listener { _, _ -> binding.progress.root.visibility = View.GONE }
            }
        } else binding.progress.root.visibility = View.GONE
        binding.ivLaunch.setOnClickListener { launch.image.openWeb(requireContext()) }
        binding.tvName.text = launch.name
        binding.tvDate.text = launch.dateFormatted
        binding.tvDetails.text = launch.details
        binding.tvDetails.visibility = if (!launch.details.isNullOrEmpty()) View.VISIBLE else View.GONE
        binding.groupResult.visibility = if (launch.success != null) View.VISIBLE else View.GONE
        binding.ivResult.setImageResource(if (launch.success == true) R.drawable.ic_checked else R.drawable.ic_cancel)
        binding.groupWebcast.visibility = if (!launch.webcast.isNullOrEmpty()) View.VISIBLE else View.GONE
        binding.ivWebcast.setOnClickListener { launch.webcast.openWeb(requireContext()) }
        binding.tvReadMore.setOnClickListener { launch.article.openWeb(requireContext()) }
        binding.clParent.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}