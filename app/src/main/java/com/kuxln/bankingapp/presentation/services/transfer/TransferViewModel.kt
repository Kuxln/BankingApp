package com.kuxln.bankingapp.presentation.services.transfer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuxln.bankingapp.data.room.exception.BankAccountNotExistsException
import com.kuxln.bankingapp.data.room.exception.NotEnoughMoneyException
import com.kuxln.bankingapp.domain.usecases.bankaccount.SearchBankAccountUseCase
import com.kuxln.bankingapp.domain.usecases.client.GetClientUseCase
import com.kuxln.bankingapp.domain.usecases.transfer.TransferUseCase
import com.kuxln.bankingapp.presentation.entity.ClientPresentationEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransferViewModel @Inject constructor(
    private val getClientUseCase: GetClientUseCase,
    private val searchBankAccountUseCase: SearchBankAccountUseCase,
    private val transferUseCase: TransferUseCase,
) : ViewModel() {

    private val _searchClientFromFlow = MutableSharedFlow<ClientPresentationEntity?>(1)
    val searchClientFromFlow = _searchClientFromFlow.asSharedFlow()

    private val _searchClientToFlow = MutableSharedFlow<ClientPresentationEntity?>(1)
    val searchClientToFlow = _searchClientToFlow.asSharedFlow()

    private var state = TransferViewState()
    private val _uiStateFlow = MutableStateFlow(state)
    val uiStateFlow = _uiStateFlow.asStateFlow()

    fun onTransferClicked(
        bankAccountNumberFrom: Long,
        bankAccountNumberTo: Long,
        quantity: Double
    ) {
        transfer(bankAccountNumberFrom, bankAccountNumberTo, quantity)
    }

    fun onSearchBankAccountFrom(bankAccountNumber: Long) {
        searchBankAccount(
            bankAccountNumber = bankAccountNumber,
            onFound = {
                _searchClientFromFlow.emit(it)
                state = state.copy(isFirstRecipientFound = true)
                _uiStateFlow.value = state
            },
            onNotFound = {
                _searchClientFromFlow.emit(null)
                state = state.copy(isFirstRecipientFound = false)
                _uiStateFlow.value = state
            }
        )
    }

    fun onSearchBankAccountTo(bankAccountNumber: Long) {
        searchBankAccount(
            bankAccountNumber = bankAccountNumber,
            onFound = {
                _searchClientToFlow.emit(it)
                state = state.copy(isSecondRecipientFound = true)
                _uiStateFlow.value = state
            },
            onNotFound = {
                _searchClientToFlow.emit(null)
                state = state.copy(isSecondRecipientFound = false)
                _uiStateFlow.value = state
            }
        )
    }

    private fun transfer(bankAccountNumberFrom: Long, bankAccountNumberTo: Long, quantity: Double) {
        viewModelScope.launch {
            try {
                state = state.copy(isEnoughMoney = true)
                _uiStateFlow.value = state
                transferUseCase(bankAccountNumberFrom, bankAccountNumberTo, quantity)
                state = state.copy(isSuccess = true)
                _uiStateFlow.value = state
            } catch (e: BankAccountNotExistsException) {
                e.printStackTrace()
            } catch (e: NotEnoughMoneyException) {
                e.printStackTrace()
                state = state.copy(isEnoughMoney = false)
                _uiStateFlow.value = state
            }
        }
    }

    private inline fun searchBankAccount(
        bankAccountNumber: Long,
        crossinline onFound: suspend (ClientPresentationEntity) -> Unit,
        crossinline onNotFound: suspend () -> Unit,
        ) {
        viewModelScope.launch {
            searchBankAccountUseCase(bankAccountNumber).collect { bankAccount ->
                bankAccount?.let {
                    getClientUseCase(bankAccount.clientId).collect { client ->
                        onFound(
                            ClientPresentationEntity(
                                lastName = client?.lastName,
                                firstName = client?.firstName,
                            )
                        )
                    }
                } ?: onNotFound()
            }
        }
    }
}