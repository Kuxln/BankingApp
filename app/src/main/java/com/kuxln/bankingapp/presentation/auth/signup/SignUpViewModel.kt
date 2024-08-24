package com.kuxln.bankingapp.presentation.auth.signup

import androidx.lifecycle.ViewModel
import com.kuxln.bankingapp.domain.usecases.auth.ForgotPasswordUseCase
import com.kuxln.bankingapp.domain.usecases.auth.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor (
    private val signUpUseCase: SignUpUseCase
): ViewModel() {

}