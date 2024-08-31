package com.kuxln.bankingapp.presentation.services.deposits.opendeposit

data class OpenDepositViewState(
    var selectedCardId: Int? = null,
    var selectedQuantity: Double = 0.0,
    var selectedDepositRate: Int = 0,
    var isSuccess: Boolean = false,
)