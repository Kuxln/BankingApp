package com.kuxln.bankingapp.presentation.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuxln.bankingapp.data.room.entity.BankAccountEntity
import com.kuxln.bankingapp.domain.usecases.bankaccount.GetAllBankAccountsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllBankAccountsUseCase: GetAllBankAccountsUseCase,
    private val savedStateHandle: SavedStateHandle,
): ViewModel() {

//    private val clientId = savedStateHandle.get<Int>("CLIENT_ID") ?: throw IllegalArgumentException()

    private val _cardsStateFlow = MutableSharedFlow<List<BankAccountEntity>>(1)
    val cardsStateFlow = _cardsStateFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            getAllBankAccountsUseCase(1).collect { dataSet ->
                _cardsStateFlow.emit(dataSet)
            }
        }
    }
}