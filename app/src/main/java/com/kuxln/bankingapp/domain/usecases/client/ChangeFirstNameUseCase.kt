package com.kuxln.bankingapp.domain.usecases.client

import com.kuxln.bankingapp.data.repository.base.ClientRepository
import javax.inject.Inject

class ChangeFirstNameUseCase @Inject constructor(
    private val clientRepository: ClientRepository
) {
    suspend operator fun invoke(clientId: Int, newFirstName: String) {
        clientRepository.changeFirstName(clientId, newFirstName)
    }
}