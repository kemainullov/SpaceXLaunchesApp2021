package com.kamil.ainullov.spacexlaunchesapp.base

import android.view.Gravity
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.kamil.ainullov.domain.core.Failure
import com.kamil.ainullov.spacexlaunchesapp.R

abstract class BaseFragment : Fragment() {

    protected fun setActionBarData(title: String, isBackButtonEnabled: Boolean = false) =
        (requireActivity() as BaseActivity).apply {
            this.title = title
            if (isBackButtonEnabled) enableBackButton() else disableBackButton()
        }

    open fun showMessageInCenter(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT)?.apply {
            setGravity(Gravity.CENTER, 0, 0)
            show()
        }
    }

    open fun handleError(failure: Failure, action: () -> Unit) {
        val errorMsg = when (failure) {
            is Failure.NetworkConnectionError -> getString(R.string.no_internet_connection)
            else -> getString(R.string.unknown_error)
        }

        MaterialAlertDialogBuilder(requireContext())
            .setTitle(R.string.error_title)
            .setMessage(errorMsg)
            .setPositiveButton(R.string.error_positive_button) { dialog, _ ->
                action()
                dialog.dismiss()
            }.setNegativeButton(R.string.error_negative_button) { dialog, _ ->
                dialog.dismiss()
            }.show()
    }
}