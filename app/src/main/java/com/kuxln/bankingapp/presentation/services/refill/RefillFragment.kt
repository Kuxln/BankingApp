package com.kuxln.bankingapp.presentation.services.refill

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.kuxln.bankingapp.R
import com.kuxln.bankingapp.data.room.entity.BankAccountEntity
import com.kuxln.bankingapp.databinding.FragmentAboutClientBinding
import com.kuxln.bankingapp.databinding.FragmentCreditsBinding
import com.kuxln.bankingapp.databinding.FragmentDepositsBinding
import com.kuxln.bankingapp.databinding.FragmentRefillBinding
import com.kuxln.bankingapp.presentation.core.ui.BaseFragment
import com.kuxln.bankingapp.presentation.home.allcards.AllCardsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RefillFragment : BaseFragment<FragmentRefillBinding>(R.layout.fragment_refill) {

//    private val viewModel: *** by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentRefillBinding.bind(view)
        binding.rvAllCards.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        binding.rvAllCards.adapter = AllCardsAdapter(
            listOf(
                BankAccountEntity(
                    clientId = 1,
                    bankAccountNumber = 4149_0000_0000_0001,
                    balance = 1337.0,
                    startDateMillis = System.currentTimeMillis()
                ),
                BankAccountEntity(
                    clientId = 1,
                    bankAccountNumber = 4149_0000_0000_0002,
                    balance = 1000000.0,
                    startDateMillis = System.currentTimeMillis()
                ),
                BankAccountEntity(
                    clientId = 1,
                    bankAccountNumber = 4149_0000_0000_0003,
                    balance = 1.0,
                    startDateMillis = System.currentTimeMillis()
                )
            )
        )
    }
}