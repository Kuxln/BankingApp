package com.kuxln.bankingapp.presentation.auth.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuxln.bankingapp.data.repository.EntityTypesRepository
import com.kuxln.bankingapp.data.room.dao.CreditTypeDAO
import com.kuxln.bankingapp.data.room.dao.DepositTypeDAO
import com.kuxln.bankingapp.data.room.dao.PurchaseTypeDAO
import com.kuxln.bankingapp.data.room.dao.RefillTypeDAO
import com.kuxln.bankingapp.domain.usecases.auth.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase,
    private val entityTypesRepository: EntityTypesRepository,
) : ViewModel() {

    private val _uiState = MutableSharedFlow<Boolean>(1)
    val uiState = _uiState.asSharedFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            entityTypesRepository.inject()
        }
    }

    fun onSignUp(email: String, password: String) {
        viewModelScope.launch {
            signUpUseCase(email, password)
            _uiState.emit(true)
        }
    }
}