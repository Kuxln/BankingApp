package com.kuxln.bankingapp.domain.usecases.auth

import com.kuxln.bankingapp.data.repository.base.ClientRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val clientRepository: ClientRepository

) {
}