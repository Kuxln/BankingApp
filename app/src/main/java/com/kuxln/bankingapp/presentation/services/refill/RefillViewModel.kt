package com.kuxln.bankingapp.presentation.services.refill

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuxln.bankingapp.data.repository.base.BankAccountRepository
import com.kuxln.bankingapp.data.room.entity.BankAccountEntity
import com.kuxln.bankingapp.domain.usecases.bankaccount.GetAllBankAccountsUseCase
import com.kuxln.bankingapp.domain.usecases.refill.RefillUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RefillViewModel @Inject constructor(
    private val getAllBankAccountsUseCase: GetAllBankAccountsUseCase,
    private val refillUseCase: RefillUseCase,
    savedStateHandle: SavedStateHandle,
): ViewModel() {

    private val clientId: Int = savedStateHandle["client_id"] ?: throw IllegalArgumentException()

    private val _cardsStateFlow = MutableSharedFlow<List<BankAccountEntity>>(1)
    val cardsStateFlow = _cardsStateFlow.asSharedFlow()

    private val state = RefillViewState()
    private val _uiStateFlow = MutableSharedFlow<RefillViewState>(1)
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

    fun onRefillClicked() {
        viewModelScope.launch(Dispatchers.IO) {
            state.selectedCardId?.let {
                refillUseCase(it, state.selectedQuantity)
            }
        }
    }
}