package com.kuxln.bankingapp.domain.usecases.client

import com.kuxln.bankingapp.data.repository.base.ClientRepository
import com.kuxln.bankingapp.data.room.entity.ClientEntity
import javax.inject.Inject

class UpdateClientUseCase @Inject constructor(
    private val clientRepository: ClientRepository
) {

    suspend operator fun invoke(clientEntity: ClientEntity) {
        return clientRepository.updateClient(clientEntity)
    }
}