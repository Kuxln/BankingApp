package com.kuxln.bankingapp.presentation.services.transfer

data class TransferViewState(
    val isFirstRecipientFound: Boolean = false,
    val isSecondRecipientFound: Boolean = false,
    val isEnoughMoney: Boolean = true,
    val isSuccess: Boolean = false,
)
