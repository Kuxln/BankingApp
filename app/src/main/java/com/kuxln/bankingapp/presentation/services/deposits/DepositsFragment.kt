package com.kuxln.bankingapp.presentation.services.deposits

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.kuxln.bankingapp.R
import com.kuxln.bankingapp.databinding.FragmentCreditsBinding
import com.kuxln.bankingapp.databinding.FragmentDepositsBinding
import com.kuxln.bankingapp.presentation.core.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DepositsFragment : BaseFragment<FragmentDepositsBinding>(R.layout.fragment_deposits) {

    private val viewModel: DepositsViewModel by viewModels()
    private val depositsAdapter = AllDepositsAdapter(listOf())
    private val args: DepositsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentDepositsBinding.bind(view)

        binding.rvAllDeposits.adapter = depositsAdapter
        val clientId = args.clientId

        binding.buttonToOpenNewDeposit.setOnClickListener {
            val action = DepositsFragmentDirections.depositsDestToOpenDepositDest(clientId)
            findNavController().navigate(action)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.depositsStateFlow.collect { listOfDeposits->
                    depositsAdapter.updateData(listOfDeposits)
                    val depositsCount = "${listOfDeposits.size} deposits in total"
                    binding.tvDepositsCount.text = depositsCount
                }
            }
        }
    }
}