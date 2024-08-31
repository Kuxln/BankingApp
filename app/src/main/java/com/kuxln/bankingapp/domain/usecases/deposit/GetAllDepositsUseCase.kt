package com.kuxln.bankingapp.domain.usecases.deposit

import com.kuxln.bankingapp.data.repository.base.DepositRepository
import com.kuxln.bankingapp.data.room.entity.DepositEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllDepositsUseCase @Inject constructor(
    private val depositRepository: DepositRepository
) {

    operator fun invoke(clientId: Int): Flow<List<DepositEntity>> {
        return depositRepository.getAllDeposits(clientId)
    }
}