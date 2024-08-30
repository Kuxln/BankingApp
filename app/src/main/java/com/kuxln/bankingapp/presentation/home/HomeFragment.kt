package com.kuxln.bankingapp.presentation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.kuxln.bankingapp.R
import com.kuxln.bankingapp.databinding.FragmentHomeBinding
import com.kuxln.bankingapp.presentation.core.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var homeCardAdapter: HomeCardAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentHomeBinding.bind(view)
        homeCardAdapter = HomeCardAdapter(listOf())
        binding.rvAllCards.adapter = homeCardAdapter
        LinearSnapHelper().attachToRecyclerView(binding.rvAllCards)


        binding.buttonAllCardsAndAccounts.setOnClickListener {
            //todo
            val action = HomeFragmentDirections.homeDestToAllCardsDest(1)
            findNavController().navigate(action)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.cardsStateFlow.collect { listOfCards ->
                    homeCardAdapter.updateData(listOfCards)
                }
            }
        }
    }
}