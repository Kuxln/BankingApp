package com.kuxln.bankingapp.presentation.auth.forgotpassword

import androidx.lifecycle.ViewModel
import com.kuxln.bankingapp.domain.usecases.auth.ForgotPasswordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor (
    private val forgotPasswordUseCase: ForgotPasswordUseCase
): ViewModel() {

}