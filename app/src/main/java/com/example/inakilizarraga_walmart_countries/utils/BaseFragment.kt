package com.example.inakilizarraga_walmart_countries.utils

import android.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.inakilizarraga_walmart_countries.di.Provider
import com.example.inakilizarraga_walmart_countries.viewmodel.MainViewModel

open class BaseFragment : Fragment() {

    protected val cViewModel by lazy {
        ViewModelProvider(requireActivity(), Provider.viewModelFactory)[MainViewModel::class.java]
    }

    fun showError(message: String? = "Unknown error", action: () -> Unit) {
        AlertDialog.Builder(requireActivity())
            .setTitle("Error occurred")
            .setMessage(message)
            .setPositiveButton("Retry") { dialog, _ ->
                action()
                dialog.dismiss()
            }
            .setNegativeButton("Dismiss") {dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }
}