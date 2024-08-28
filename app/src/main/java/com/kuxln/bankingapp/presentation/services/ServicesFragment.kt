package com.kuxln.bankingapp.presentation.services

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kuxln.bankingapp.R
import com.kuxln.bankingapp.databinding.FragmentServicesBinding
import com.kuxln.bankingapp.presentation.core.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ServicesFragment : BaseFragment<FragmentServicesBinding>(R.layout.fragment_services) {

    private val viewModel: ServicesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentServicesBinding.bind(view)

        setupListeners()
    }

    private fun setupListeners() {
        binding.buttonRefill.setOnClickListener {
            val action = ServicesFragmentDirections.actionToRefillDest()
            findNavController().navigate(action)
        }

        binding.buttonWithdraw.setOnClickListener {
            val action = ServicesFragmentDirections.actionToWithdrawDest()
            findNavController().navigate(action)
        }

        binding.buttonCredits.setOnClickListener {
            val action = ServicesFragmentDirections.actionToCreditsDest()
            findNavController().navigate(action)
        }

        binding.buttonDeposits.setOnClickListener {
            val action = ServicesFragmentDirections.actionToDepositsDest()
            findNavController().navigate(action)
        }

        binding.buttonTransfer.setOnClickListener {
            val action = ServicesFragmentDirections.actionToTransferDest()
            findNavController().navigate(action)
        }

        binding.buttonClientSettings.setOnClickListener {
            val action = ServicesFragmentDirections.actionToAboutClientDest()
            findNavController().navigate(action)
        }
    }
}