package com.kuxln.bankingapp.presentation.services.credits

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuxln.bankingapp.data.room.entity.BankAccountEntity
import com.kuxln.bankingapp.data.room.entity.CreditEntity
import com.kuxln.bankingapp.domain.usecases.credit.GetAllCreditsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreditsViewModel @Inject constructor(
    private val getAllCreditsUseCase: GetAllCreditsUseCase,
    savedStateHandle: SavedStateHandle,
): ViewModel() {

    private val clientId: Int = savedStateHandle["client_id"] ?: throw IllegalArgumentException()

    private val _creditsStateFlow = MutableSharedFlow<List<CreditEntity>>(1)
    val creditsStateFlow = _creditsStateFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            getAllCreditsUseCase(clientId).collect { dataSet ->
                _creditsStateFlow.emit(dataSet)
            }
        }
    }
}