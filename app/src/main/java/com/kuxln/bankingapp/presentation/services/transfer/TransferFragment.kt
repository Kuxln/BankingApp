package com.kuxln.bankingapp.presentation.services.transfer

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.kuxln.bankingapp.R
import com.kuxln.bankingapp.databinding.FragmentTransferBinding
import com.kuxln.bankingapp.presentation.core.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TransferFragment : BaseFragment<FragmentTransferBinding>(R.layout.fragment_transfer) {

    private val viewModel: TransferViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentTransferBinding.bind(view)

        setupListeners()
        setupObservers()
    }

    private fun setupListeners() = with(binding) {
        buttonTransfer.setOnClickListener {
            val cardNumberFrom = etCardNumberFrom.text.toString().toLong()
            val cardNumberTo = etCardNumberTo.text.toString().toLong()
            val quantity = etQuantity.text.toString().toDouble()
            if (quantity <= 0 ) {
                Toast.makeText(requireActivity(), "Enter valid value", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            viewModel.onTransferClicked(cardNumberFrom, cardNumberTo, quantity)
        }

        etCardNumberFrom.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val cardNumber = s.toString()
                if (cardNumber.length >= 16) {
                    viewModel.onSearchBankAccountFrom(cardNumber.toLong())
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        etCardNumberTo.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val cardNumber = s.toString()
                if (cardNumber.length >= 16) {
                    viewModel.onSearchBankAccountTo(cardNumber.toLong())
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun setupObservers() = with(binding) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.searchClientFromFlow.collect { client ->
                    client?.let {
                        val fullName = "${client.lastName} ${client.firstName}'s card "
                        tvRecipientNameFrom.text = fullName
                    } ?: setRecipientNameFromNotFound()
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.searchClientToFlow.collect { client ->
                    client?.let {
                        val fullName = "${it.lastName} ${it.firstName}'s card "
                        tvRecipientNameTo.text = fullName
                    } ?: setRecipientNameToNotFound()
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiStateFlow.collectLatest { state ->
                    System.err.println(state)
                    val isEnabled = state.isFirstRecipientFound && state.isSecondRecipientFound
                    buttonTransfer.isEnabled = isEnabled
                    if (!state.isEnoughMoney) {
                        Toast.makeText(requireActivity(), "Not enough money", Toast.LENGTH_SHORT)
                            .show()
                    }
                    if (state.isSuccess) {
                        Toast.makeText(requireActivity(), "Success", Toast.LENGTH_SHORT).show()
                        findNavController().popBackStack()
                    }
                }
            }
        }
    }

    private fun setRecipientNameFromNotFound() {
        binding.tvRecipientNameFrom.text = "Card not found"
    }

    private fun setRecipientNameToNotFound() {
        binding.tvRecipientNameTo.text = "Card not found"
    }
}