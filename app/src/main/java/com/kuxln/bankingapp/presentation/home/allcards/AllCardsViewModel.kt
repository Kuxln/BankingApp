package com.kuxln.bankingapp.presentation.home.allcards

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuxln.bankingapp.data.repository.base.BankAccountRepository
import com.kuxln.bankingapp.data.room.entity.BankAccountEntity
import com.kuxln.bankingapp.domain.usecases.bankaccount.GetAllBankAccountsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllCardsViewModel @Inject constructor(
    private val getAllBankAccountsUseCase: GetAllBankAccountsUseCase,
    savedStateHandle: SavedStateHandle,
): ViewModel() {

    private val clientId: Int = savedStateHandle["client_id"] ?: throw IllegalArgumentException()

    private val _cardsStateFlow = MutableSharedFlow<List<BankAccountEntity>>(1)
    val cardsStateFlow = _cardsStateFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            getAllBankAccountsUseCase(clientId).collect { dataSet ->
                _cardsStateFlow.emit(dataSet)
            }
        }
    }
}