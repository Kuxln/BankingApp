package com.kuxln.bankingapp.presentation.services.credits

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearSnapHelper
import com.kuxln.bankingapp.R
import com.kuxln.bankingapp.databinding.FragmentAboutClientBinding
import com.kuxln.bankingapp.databinding.FragmentAllCardsBinding
import com.kuxln.bankingapp.databinding.FragmentCreditsBinding
import com.kuxln.bankingapp.presentation.core.adapters.AllCardsAdapter
import com.kuxln.bankingapp.presentation.core.ui.BaseFragment
import com.kuxln.bankingapp.presentation.home.HomeFragmentDirections
import com.kuxln.bankingapp.presentation.home.allcards.AllCardsFragmentArgs
import com.kuxln.bankingapp.presentation.home.allcards.AllCardsFragmentDirections
import com.kuxln.bankingapp.presentation.home.allcards.AllCardsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CreditsFragment : BaseFragment<FragmentCreditsBinding>(R.layout.fragment_credits) {

    private val viewModel: CreditsViewModel by viewModels()
    private val creditsAdapter = AllCreditsAdapter(listOf())
    private val args: CreditsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentCreditsBinding.bind(view)

        binding.rvAllCredits.adapter = creditsAdapter
        val clientId = args.clientId

        binding.buttonToOpenNewCredit.setOnClickListener {
            val action = CreditsFragmentDirections.creditsDestToOpenCreditDest(clientId)
            findNavController().navigate(action)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.creditsStateFlow.collect { listOfCredits->
                    creditsAdapter.updateData(listOfCredits)
                    val creditsCount = "${listOfCredits.size} credits in total"
                    binding.tvCreditsCount.text = creditsCount
                }
            }
        }
    }
}