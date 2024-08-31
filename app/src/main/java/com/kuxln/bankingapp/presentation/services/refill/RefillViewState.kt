package com.kuxln.bankingapp.presentation.services.refill

data class RefillViewState(
    var selectedCardId: Int? = null,
    var selectedQuantity: Double = 0.0,
)