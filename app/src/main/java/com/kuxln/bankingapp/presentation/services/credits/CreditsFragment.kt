package com.kuxln.bankingapp.presentation.services.credits

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.kuxln.bankingapp.R
import com.kuxln.bankingapp.databinding.FragmentAboutClientBinding
import com.kuxln.bankingapp.databinding.FragmentCreditsBinding
import com.kuxln.bankingapp.presentation.core.ui.BaseFragment
import com.kuxln.bankingapp.presentation.home.HomeFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreditsFragment : BaseFragment<FragmentCreditsBinding>(R.layout.fragment_credits) {

//    private val viewModel: *** by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentCreditsBinding.bind(view)

        binding.buttonToOpenCredit.setOnClickListener {
            val action = CreditsFragmentDirections.creditsDestToOpenCreditDest(1)
            findNavController().navigate(action)
        }
    }
}