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

    private var clientId: Int? = null
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var homeCardAdapter: HomeCardAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentHomeBinding.bind(view)
        homeCardAdapter = HomeCardAdapter(listOf())
        binding.rvAllCards.adapter = homeCardAdapter
        LinearSnapHelper().attachToRecyclerView(binding.rvAllCards)

        binding.buttonAllCardsAndAccounts.setOnClickListener {
            clientId?.let {
                val action = HomeFragmentDirections.homeDestToAllCardsDest(it)
                findNavController().navigate(action)
            }
        }

        setupCollectors()
    }

    private fun setupCollectors() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.cardsStateFlow.collect { listOfCards ->
                    homeCardAdapter.updateData(listOfCards)
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.clientIdFlow.collect { clientId ->
                    clientId?.let {
                        this@HomeFragment.clientId = it
                    } ?: navigateToSignIn()
                }
            }
        }
    }

    private fun navigateToSignIn() {
        System.err.println("navigateToSignIn()")
        val action = HomeFragmentDirections.actionHomeDestToSignInFragment()
        findNavController().navigate(action)
    }
}