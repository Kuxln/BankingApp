package com.kuxln.bankingapp.presentation.home.allcards

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.kuxln.bankingapp.R
import com.kuxln.bankingapp.data.room.entity.BankAccountEntity
import com.kuxln.bankingapp.databinding.FragmentAllCardsBinding
import com.kuxln.bankingapp.databinding.FragmentHomeBinding
import com.kuxln.bankingapp.presentation.core.adapters.AllCardsAdapter
import com.kuxln.bankingapp.presentation.core.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AllCardsFragment : BaseFragment<FragmentAllCardsBinding>(R.layout.fragment_all_cards) {

    private val viewModel: AllCardsViewModel by viewModels()
    private val cardAdapter = AllCardsAdapter(listOf())
    private val args: AllCardsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentAllCardsBinding.bind(view)
        binding.rvAllCards.adapter = cardAdapter
        LinearSnapHelper().attachToRecyclerView(binding.rvAllCards)
        val clientId = args.clientId
        binding.buttonToAddNewCard.setOnClickListener {
            val action = AllCardsFragmentDirections.allCardsDestToAddNewCardDest(clientId)
            findNavController().navigate(action)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.cardsStateFlow.collect { listOfCards ->
                    cardAdapter.updateData(listOfCards)
                    val cardsCount = "${listOfCards.size} cards in total"
                    binding.tvCardsCount.text = cardsCount
                }
            }
        }
    }
}