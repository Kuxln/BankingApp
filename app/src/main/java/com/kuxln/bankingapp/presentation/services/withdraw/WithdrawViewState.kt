package com.kuxln.bankingapp.presentation.services.withdraw

data class WithdrawViewState(
    var selectedCardId: Int? = null,
    var selectedQuantity: Double = 0.0,
    var isSuccess: Boolean = false,
)