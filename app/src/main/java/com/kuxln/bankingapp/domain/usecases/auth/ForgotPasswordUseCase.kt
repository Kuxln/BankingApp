package com.kuxln.bankingapp.domain.usecases.auth

import com.kuxln.bankingapp.data.repository.base.ClientRepository
import javax.inject.Inject

class ForgotPasswordUseCase @Inject constructor(
    private val clientRepository: ClientRepository
) {
    suspend operator fun invoke(login: String, password: String) {
        clientRepository.changePasswordOnForgot(login, password)
    }
}