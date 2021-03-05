package com.kamil.ainullov.spacexlaunchesapp.base

import android.view.Gravity
import android.widget.Toast
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    protected fun setActionBarData(title: String, isBackButtonEnabled: Boolean = false) =
        (requireActivity() as BaseActivity).apply {
            this.title = title
            if (isBackButtonEnabled) enableBackButton() else disableBackButton()
        }

    open fun showMessageInCenter(message: String) {
        val toast = Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }
}