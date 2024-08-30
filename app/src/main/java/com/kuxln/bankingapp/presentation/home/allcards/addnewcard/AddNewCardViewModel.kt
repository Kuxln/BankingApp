package com.kuxln.bankingapp.presentation.home.allcards.addnewcard

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuxln.bankingapp.domain.usecases.bankaccount.CreateNewBankAccountUseCase
import com.kuxln.bankingapp.domain.usecases.bankaccount.GetNewBankAccountNumberUseCase
import com.kuxln.bankingapp.presentation.entity.CardColorEnum
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNewCardViewModel @Inject constructor(
    private val getNewBankAccountNumberUseCase: GetNewBankAccountNumberUseCase,
    private val createNewBankAccountUseCase: CreateNewBankAccountUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val clientId: Int = savedStateHandle["client_id"] ?: throw IllegalStateException("Client id not exists")

    private val state = AddNewCardViewState()
    private val _uiStateFlow = MutableSharedFlow<AddNewCardViewState>(1)
    val uiStateFlow = _uiStateFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            state.cardNumber = getNewBankAccountNumberUseCase()
            _uiStateFlow.emit(state)
        }
    }

    fun onCardColorSelected(cardColorEnum: CardColorEnum) {
        viewModelScope.launch {
            state.cardColor = cardColorEnum.colorId
            _uiStateFlow.emit(state)
        }
    }

    fun onCreateCardClicked() {
        viewModelScope.launch {
            createNewBankAccountUseCase(clientId, state.cardColor)
            state.isComplete = true
            _uiStateFlow.emit(state)
        }
    }
}