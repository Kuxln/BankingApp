package com.kuxln.bankingapp.presentation.services

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.kuxln.bankingapp.R
import com.kuxln.bankingapp.databinding.FragmentServicesBinding
import com.kuxln.bankingapp.presentation.core.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ServicesFragment : BaseFragment<FragmentServicesBinding>(R.layout.fragment_services) {

    private val viewModel: ServicesViewModel by viewModels()
    private var clientId: Int? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentServicesBinding.bind(view)
        setupObservers()
        setupListeners()

    }

    private fun setupObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.clientIdFlow.collect { clientId ->
                    clientId?.let {
                        this@ServicesFragment.clientId = it
                    }
                }
            }
        }
    }

    private fun setupListeners() {
        binding.buttonRefill.setOnClickListener {
            clientId?.let {
                val action = ServicesFragmentDirections.servicesDestToRefillDest(it)
                findNavController().navigate(action)
            }
        }

        binding.buttonWithdraw.setOnClickListener {
            clientId?.let {
                val action = ServicesFragmentDirections.servicesDestToWithdrawDest(it)
                findNavController().navigate(action)
            }
        }

        binding.buttonCredits.setOnClickListener {
            clientId?.let {
                val action = ServicesFragmentDirections.servicesDestToCreditsDest(it)
                findNavController().navigate(action)
            }
        }

        binding.buttonDeposits.setOnClickListener {
            clientId?.let {
                val action = ServicesFragmentDirections.servicesDestToDepositsDest(it)
                findNavController().navigate(action)
            }
        }

        binding.buttonTransfer.setOnClickListener {
            clientId?.let {
                val action = ServicesFragmentDirections.servicesDestToTransferDest(it)
                findNavController().navigate(action)
            }
        }

        binding.buttonClientSettings.setOnClickListener {
            clientId?.let {
                val action = ServicesFragmentDirections.servicesDestToAboutClientDest(it)
                findNavController().navigate(action)
            }
        }
    }
}