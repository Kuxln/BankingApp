package com.kuxln.bankingapp.presentation.services.deposits.opendeposit

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.kuxln.bankingapp.R
import com.kuxln.bankingapp.databinding.FragmentCreateDepositBinding
import com.kuxln.bankingapp.presentation.core.adapters.AllCardsAdapter
import com.kuxln.bankingapp.presentation.core.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class OpenDepositFragment :
    BaseFragment<FragmentCreateDepositBinding>(R.layout.fragment_create_deposit) {

    private val viewModel: OpenDepositViewModel by viewModels()
    private val allCardsAdapter = AllCardsAdapter(
        listOf(),
        onClick = {
            viewModel.onCardSelected(it)
            Toast.makeText(requireActivity(), "Card selected", Toast.LENGTH_SHORT).show()
        }
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentCreateDepositBinding.bind(view)
        binding.rvAllCards.adapter = allCardsAdapter

        binding.buttonOpenDeposit.setOnClickListener {
            val quantity = binding.etQuantity.text.toString().toDouble()
            val depositRate = binding.etRate.text.toString().toInt()

            if (quantity > 0 && depositRate > 12) {
                viewModel.onQuantitySelected(quantity)
                viewModel.onCreditRateSelected(depositRate)
                viewModel.onOpenDepositClicked()
            } else {
                Toast.makeText(requireActivity(), "Enter valid value", Toast.LENGTH_SHORT).show()
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.cardsStateFlow.collect { listOfCards ->
                    allCardsAdapter.updateData(listOfCards)
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiStateFlow.collect { state ->
                    if (state.isSuccess) {
                        Toast.makeText(requireActivity(), "Success", Toast.LENGTH_SHORT).show()
                        findNavController().popBackStack()
                    }
                }
            }
        }
    }
}