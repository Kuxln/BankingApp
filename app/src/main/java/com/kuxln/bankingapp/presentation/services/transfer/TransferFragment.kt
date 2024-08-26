package com.kuxln.bankingapp.presentation.services.transfer

import android.os.Bundle
import android.view.View
import com.kuxln.bankingapp.R
import com.kuxln.bankingapp.databinding.FragmentAboutClientBinding
import com.kuxln.bankingapp.databinding.FragmentCreditsBinding
import com.kuxln.bankingapp.databinding.FragmentDepositsBinding
import com.kuxln.bankingapp.databinding.FragmentTransferBinding
import com.kuxln.bankingapp.presentation.core.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TransferFragment : BaseFragment<FragmentTransferBinding>(R.layout.fragment_transfer) {

//    private val viewModel: *** by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentTransferBinding.bind(view)
    }
}