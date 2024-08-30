package com.kuxln.bankingapp.presentation.home.allcards.addnewcard

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.kuxln.bankingapp.R
import com.kuxln.bankingapp.databinding.FragmentAddNewCardBinding
import com.kuxln.bankingapp.presentation.core.ui.BaseFragment
import com.kuxln.bankingapp.presentation.entity.CardColorEnum
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddNewCardFragment : BaseFragment<FragmentAddNewCardBinding>(R.layout.fragment_add_new_card) {

    private val viewModel: AddNewCardViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentAddNewCardBinding.bind(view)

        binding.ivCardColor.setBackgroundColor(resources.getColor(R.color.black))
        binding.ivCardColor.setOnClickListener {
            createColorPopupMenu()
        }

        binding.buttonCreate.setOnClickListener {
            viewModel.onCreateCardClicked()
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiStateFlow.collect { state ->
                    binding.tvCardNumber.text = state.cardNumber.toString()
                    binding.ivCardColor.setBackgroundColor(resources.getColor(state.cardColor))

                    if (state.isComplete) {
                        Toast.makeText(requireActivity(), "Card successfully created", Toast.LENGTH_SHORT).show()
                        findNavController().popBackStack()
                    }
                }
            }
        }
    }

    private fun createColorPopupMenu() {
        val popupMenu = PopupMenu(requireActivity(), binding.ivCardColor)
        popupMenu.menuInflater.inflate(R.menu.menu_card_color_popup, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.color_dark_red -> viewModel.onCardColorSelected(CardColorEnum.DARK_RED)

                R.id.color_dark_blue -> viewModel.onCardColorSelected(CardColorEnum.DARK_BLUE)

                R.id.color_dark_green -> viewModel.onCardColorSelected(CardColorEnum.DARK_GREEN)

                R.id.color_dark_magenta -> viewModel.onCardColorSelected(CardColorEnum.DARK_MAGENTA)

                R.id.color_dark_orange -> viewModel.onCardColorSelected(CardColorEnum.DARK_ORANGE)
            }
            return@setOnMenuItemClickListener true
        }
        popupMenu.show()
    }
}