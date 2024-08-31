package com.kuxln.bankingapp.presentation.services.credits.opencredit

data class OpenCreditViewState(
    var selectedCardId: Int? = null,
    var selectedQuantity: Double = 0.0,
    var selectedDepositRate: Int = 0,
    var isSuccess: Boolean = false,
)