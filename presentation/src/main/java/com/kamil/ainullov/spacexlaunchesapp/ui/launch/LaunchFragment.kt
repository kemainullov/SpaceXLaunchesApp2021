package com.kamil.ainullov.spacexlaunchesapp.ui.launch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.kamil.ainullov.spacexlaunchesapp.base.BaseFragment
import com.kamil.ainullov.spacexlaunchesapp.databinding.FragmentLaunchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LaunchFragment : BaseFragment() {

    private var _binding: FragmentLaunchBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LaunchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLaunchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}