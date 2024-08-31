package com.kuxln.bankingapp.presentation.auth.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuxln.bankingapp.domain.usecases.auth.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase,
) : ViewModel() {

    private val _uiState = MutableSharedFlow<Boolean>(1)
    val uiState = _uiState.asSharedFlow()

    fun onSignIn(email: String, password: String) {
        viewModelScope.launch {
            signInUseCase(email, password)
            _uiState.emit(true)
        }
    }
}