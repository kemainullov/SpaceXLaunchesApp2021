package com.kamil.ainullov.spacexlaunchesapp.ui.upcoming_launches

import android.os.Bundle
import android.view.*
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI.onNavDestinationSelected
import com.kamil.ainullov.spacexlaunchesapp.R
import com.kamil.ainullov.spacexlaunchesapp.base.BaseFragment
import com.kamil.ainullov.spacexlaunchesapp.databinding.FragmentUpcomingLaunchesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpcomingLaunchesFragment : BaseFragment() {

    private var _binding: FragmentUpcomingLaunchesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: UpcomingLaunchesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUpcomingLaunchesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setActionBarData(getString(R.string.upcoming_launches))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) =
        inflater.inflate(R.menu.menu_upcoming_launches, menu)

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onNavDestinationSelected(item, findNavController())
        return super.onOptionsItemSelected(item)
    }

}