package com.kuxln.bankingapp.presentation.services.deposits

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuxln.bankingapp.data.room.entity.DepositEntity
import com.kuxln.bankingapp.domain.usecases.deposit.GetAllDepositsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DepositsViewModel @Inject constructor(
    private val getAllDepositsUseCase: GetAllDepositsUseCase,
    savedStateHandle: SavedStateHandle,
): ViewModel() {

    private val clientId: Int = savedStateHandle["client_id"] ?: throw IllegalArgumentException()

    private val _depositsStateFlow = MutableSharedFlow<List<DepositEntity>>(1)
    val depositsStateFlow = _depositsStateFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            getAllDepositsUseCase(clientId).collect { dataSet ->
                _depositsStateFlow.emit(dataSet)
            }
        }
    }
}