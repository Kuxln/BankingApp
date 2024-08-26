package com.kuxln.bankingapp.presentation.services.deposits

import android.os.Bundle
import android.view.View
import com.kuxln.bankingapp.R
import com.kuxln.bankingapp.databinding.FragmentAboutClientBinding
import com.kuxln.bankingapp.databinding.FragmentCreditsBinding
import com.kuxln.bankingapp.databinding.FragmentDepositsBinding
import com.kuxln.bankingapp.presentation.core.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DepositsFragment : BaseFragment<FragmentDepositsBinding>(R.layout.fragment_deposits) {

//    private val viewModel: *** by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentDepositsBinding.bind(view)
    }
}