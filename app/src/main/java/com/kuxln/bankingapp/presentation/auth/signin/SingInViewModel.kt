package com.kuxln.bankingapp.presentation.auth.signin

import androidx.lifecycle.ViewModel
import com.kuxln.bankingapp.domain.usecases.auth.ForgotPasswordUseCase
import com.kuxln.bankingapp.domain.usecases.auth.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SingInViewModel @Inject constructor (
    private val signInUseCase: SignInUseCase
): ViewModel() {

}