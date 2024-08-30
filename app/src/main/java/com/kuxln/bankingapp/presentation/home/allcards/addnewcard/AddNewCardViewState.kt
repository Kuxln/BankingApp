package com.kuxln.bankingapp.presentation.home.allcards.addnewcard

import com.kuxln.bankingapp.R

data class AddNewCardViewState(
    var cardNumber: Long = 0,
    var cardColor: Int = R.color.main_card_dark_blue,
    var isComplete: Boolean = false,
)