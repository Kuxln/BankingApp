package com.kuxln.bankingapp.domain.usecases.client

import com.kuxln.bankingapp.data.repository.base.ClientRepository
import com.kuxln.bankingapp.data.room.entity.ClientEntity
import com.kuxln.bankingapp.presentation.entity.ClientPresentationEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetClientUseCase @Inject constructor(
    private val clientRepository: ClientRepository
) {

    operator fun invoke(clientId: Int): Flow<ClientEntity?> {
        return clientRepository.getClientById(clientId)
    }
}