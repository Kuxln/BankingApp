package com.kuxln.bankingapp.presentation.services

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.kuxln.bankingapp.R
import com.kuxln.bankingapp.databinding.FragmentHomeBinding
import com.kuxln.bankingapp.databinding.FragmentServicesBinding
import com.kuxln.bankingapp.presentation.core.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ServicesFragment: BaseFragment<FragmentServicesBinding>(R.layout.fragment_services) {

    private val viewModel: ServicesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentServicesBinding.bind(view)

        setupListeners()
    }

    private fun setupListeners() {
        binding.buttonRefill.setOnClickListener {

        }

        binding.buttonWithdraw.setOnClickListener {

        }

        binding.buttonCredits.setOnClickListener {

        }

        binding.buttonDeposits.setOnClickListener {

        }

        binding.buttonTransfer.setOnClickListener {

        }

        binding.buttonClientSettings.setOnClickListener {

        }
    }
}