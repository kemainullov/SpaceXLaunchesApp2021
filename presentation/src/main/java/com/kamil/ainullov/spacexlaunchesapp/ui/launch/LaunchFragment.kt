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
        viewModel.setEvent(LaunchContract.Event.GetLaunch(args.launchId))
    }

    private fun observeStates() {
        lifecycleScope.launch {
            // Collect ui state
            viewModel.uiState.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect {
                    when (it.launchState) {
                        is LaunchContract.LaunchState.Idle -> {
                            binding.progress.root.visibility = View.VISIBLE
                            binding.progress.root.visibility = View.GONE
                        }
                        is LaunchContract.LaunchState.Loading -> {
                            binding.progress.root.visibility = View.VISIBLE
                        }
                        is LaunchContract.LaunchState.Success -> {
                            binding.progress.root.visibility = View.VISIBLE
                            binding.progress.root.visibility = View.GONE
                            setLaunchData(it.launchState.launch)
                        }
                    }
                }
        }

        lifecycleScope.launchWhenStarted {
            // Collect side effects
            viewModel.effect.collect {
                when (it) {
                    is LaunchContract.Effect.ShowErrorDialog -> {
                        binding.clParent.visibility = View.GONE
                        binding.progress.root.visibility = View.GONE
                        handleError(it.failure) {
                            viewModel.setEvent(LaunchContract.Event.GetLaunch(args.launchId))
                        }
                    }
                }
            }
        }
    }

    private fun setLaunchData(launch: LaunchEntity) = binding.apply {
        if (!launch.image.isNullOrBlank()) {
            ivLaunch.load(launch.image) {
                listener { _, _ -> progress.root.visibility = View.GONE }
            }
        } else progress.root.visibility = View.GONE
        ivLaunch.setOnClickListener { launch.image.openWeb(requireContext()) }
        tvName.text = launch.name
        tvDate.text = launch.dateFormatted
        tvDetails.text = launch.details
        tvDetails.visibility = if (!launch.details.isNullOrEmpty()) View.VISIBLE else View.GONE
        groupResult.visibility = if (launch.success != null) View.VISIBLE else View.GONE
        ivResult.setImageResource(if (launch.success == true) R.drawable.ic_checked else R.drawable.ic_cancel)
        groupWebcast.visibility = if (!launch.webcast.isNullOrEmpty()) View.VISIBLE else View.GONE
        ivWebcast.setOnClickListener { launch.webcast.openWeb(requireContext()) }
        tvReadMore.setOnClickListener { launch.article.openWeb(requireContext()) }
        clParent.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}