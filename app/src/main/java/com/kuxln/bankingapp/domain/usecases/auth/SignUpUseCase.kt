package com.kuxln.bankingapp.domain.usecases.auth

import com.kuxln.bankingapp.data.repository.base.ClientRepository
import com.kuxln.bankingapp.data.room.entity.ClientEntity
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val clientRepository: ClientRepository
) {
    suspend operator fun invoke(login: String, password: String) {
        clientRepository.signUp(
            ClientEntity(
                login = login,
                password = password,
                startDateMillis = System.currentTimeMillis()
            )
        )
    }
}