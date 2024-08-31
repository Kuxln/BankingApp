package com.kuxln.bankingapp.presentation.services.credits.opencredit

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuxln.bankingapp.data.room.entity.BankAccountEntity
import com.kuxln.bankingapp.domain.usecases.bankaccount.GetAllBankAccountsUseCase
import com.kuxln.bankingapp.domain.usecases.deposit.CreateDepositUseCase
import com.kuxln.bankingapp.presentation.services.deposits.opendeposit.OpenDepositViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OpenCreditViewModel @Inject constructor(
    private val getAllBankAccountsUseCase: GetAllBankAccountsUseCase,
    private val createCreditUseCase: CreateDepositUseCase,
    savedStateHandle: SavedStateHandle,
): ViewModel() {

    private val clientId: Int = savedStateHandle["client_id"] ?: throw IllegalArgumentException()

    private val _cardsStateFlow = MutableSharedFlow<List<BankAccountEntity>>(1)
    val cardsStateFlow = _cardsStateFlow.asSharedFlow()

    private val state = OpenCreditViewState()
    private val _uiStateFlow = MutableSharedFlow<OpenCreditViewState>(1)
    val uiStateFlow = _uiStateFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            getAllBankAccountsUseCase(clientId).collect { dataSet ->
                _cardsStateFlow.emit(dataSet)
            }
        }
    }

    fun onCardSelected(bankAccountId: Int) {
        state.selectedCardId = bankAccountId
    }

    fun onQuantitySelected(quantity: Double) {
        state.selectedQuantity = quantity
    }

    fun onCreditRateSelected(selectedDepositRate: Int) {
        state.selectedDepositRate = selectedDepositRate
    }

    fun onOpenCreditClicked() {
        viewModelScope.launch(Dispatchers.IO) {
            state.selectedCardId?.let {
                createCreditUseCase(it, state.selectedQuantity, state.selectedDepositRate)
                state.isSuccess = true
                _uiStateFlow.emit(state)
            }
        }
    }
}