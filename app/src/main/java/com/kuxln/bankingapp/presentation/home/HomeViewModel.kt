package com.kuxln.bankingapp.presentation.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuxln.bankingapp.data.repository.base.BankAccountRepository
import com.kuxln.bankingapp.data.repository.base.ClientRepository
import com.kuxln.bankingapp.data.room.entity.BankAccountEntity
import com.kuxln.bankingapp.data.room.entity.ClientEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val bankAccountRepository: BankAccountRepository,
    private val savedStateHandle: SavedStateHandle,
): ViewModel() {

//    private val clientId = savedStateHandle.get<Int>("CLIENT_ID") ?: throw IllegalArgumentException()

    private val _cardsStateFlow = MutableSharedFlow<List<BankAccountEntity>>(1)
    val cardsStateFlow = _cardsStateFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            bankAccountRepository.getAllBankAccounts(1).collect { dataSet ->
                _cardsStateFlow.emit(dataSet)
            }
        }
    }
}