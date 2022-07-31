package com.example.torangscreensettings

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.torang_core.navigation.TermsNavigation
import com.example.torang_core.util.Logger
import com.example.torangscreensettings.databinding.FragmentSettingsBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SettingsFragment : Fragment() {
    @Inject
    lateinit var termsNavigation: TermsNavigation

    private val viewModel: SettingsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSettingsBinding.inflate(layoutInflater, container, false)

        binding.constraintLayout0.setOnClickListener {
            viewModel.logout()
            requireActivity().finish()
        }

        binding.constraintLayout4.setOnClickListener {
            termsNavigation.go(requireContext())
        }

        return binding.root
    }
}