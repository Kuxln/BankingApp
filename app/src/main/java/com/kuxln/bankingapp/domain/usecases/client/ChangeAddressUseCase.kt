package com.kuxln.bankingapp.domain.usecases.client

import com.kuxln.bankingapp.data.repository.base.ClientRepository
import javax.inject.Inject

class ChangeAddressUseCase @Inject constructor(
    private val clientRepository: ClientRepository
) {
    suspend operator fun invoke(clientId: Int, newAddress: String) {
        clientRepository.changeAddress(clientId, newAddress)
    }
}