package com.kuxln.bankingapp.presentation.home.allcards

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.kuxln.bankingapp.R
import com.kuxln.bankingapp.data.room.entity.BankAccountEntity
import com.kuxln.bankingapp.databinding.FragmentHomeBinding
import com.kuxln.bankingapp.presentation.core.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AllCardsFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

//    private val viewModel: HomeViewModel by viewModels()
    private lateinit var cardAdapter: AllCardsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentHomeBinding.bind(view)
        binding.rvAllCards.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
//        cardAdapter = CardAdapter(listOf())
//        binding.rvAllCards.adapter = cardAdapter
        LinearSnapHelper().attachToRecyclerView(binding.rvAllCards)

        binding.buttonAddNewCard.setOnClickListener {
//            viewModel.onCreateNewCardClicked()
        }

//        viewLifecycleOwner.lifecycleScope.launch {
//            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
//                viewModel.cardsStateFlow.collect { listOfCards ->
//                    cardAdapter.updateData(listOfCards)
//                }
//            }
//        }
    }
}