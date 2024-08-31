package com.kuxln.bankingapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuxln.bankingapp.data.datastore.DataStore
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
    private val dataStore: DataStore,
) : ViewModel() {

    private val _cardsStateFlow = MutableSharedFlow<List<BankAccountEntity>>(1)
    val cardsStateFlow = _cardsStateFlow.asSharedFlow()

    private var clientId: Int? = null
    private val _clientIdFlow = MutableSharedFlow<Int?>(1)
    val clientIdFlow = _clientIdFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            dataStore.clientIdFlow.collect { savedClientId ->
                savedClientId?.let {
                    clientId = savedClientId
                    _clientIdFlow.emit(clientId)
                    getAllBankAccounts()
                } ?: sendToSignIn()
            }
        }
    }

    private fun getAllBankAccounts() {
        viewModelScope.launch {
            clientId?.let {
                getAllBankAccountsUseCase(it).collect { dataSet ->
                    _cardsStateFlow.emit(dataSet)
                }
            }
        }
    }

    private fun sendToSignIn() {
        viewModelScope.launch {
            _clientIdFlow.emit(null)
        }

    }
}