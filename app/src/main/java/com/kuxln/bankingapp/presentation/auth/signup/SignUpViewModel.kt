package com.kuxln.bankingapp.presentation.auth.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
    purchaseTypeDAO: PurchaseTypeDAO,
    creditTypeDAO: CreditTypeDAO,
    depositTypeDAO: DepositTypeDAO,
    refillTypeDAO: RefillTypeDAO,
) : ViewModel() {

    private val _uiState = MutableSharedFlow<Boolean>(1)
    val uiState = _uiState.asSharedFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            purchaseTypeDAO.insert()
            creditTypeDAO.insert()
            depositTypeDAO.insert()
            refillTypeDAO.insert()
        }
    }

    fun onSignUp(email: String, password: String) {
        viewModelScope.launch {
            signUpUseCase(email, password)
            _uiState.emit(true)
        }
    }
}