package com.kuxln.bankingapp.presentation.services.withdraw

import android.os.Bundle
import android.view.View
import com.kuxln.bankingapp.R
import com.kuxln.bankingapp.databinding.FragmentAboutClientBinding
import com.kuxln.bankingapp.databinding.FragmentCreditsBinding
import com.kuxln.bankingapp.databinding.FragmentDepositsBinding
import com.kuxln.bankingapp.databinding.FragmentWithdrawBinding
import com.kuxln.bankingapp.presentation.core.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WithdrawFragment : BaseFragment<FragmentWithdrawBinding>(R.layout.fragment_withdraw) {

//    private val viewModel: *** by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentWithdrawBinding.bind(view)
    }
}