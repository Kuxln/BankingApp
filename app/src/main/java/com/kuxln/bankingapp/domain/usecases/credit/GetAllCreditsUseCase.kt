package com.kuxln.bankingapp.domain.usecases.credit

import com.kuxln.bankingapp.data.repository.base.CreditRepository
import com.kuxln.bankingapp.data.repository.base.DepositRepository
import com.kuxln.bankingapp.data.room.entity.CreditEntity
import com.kuxln.bankingapp.data.room.entity.DepositEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCreditsUseCase @Inject constructor(
    private val creditRepository: CreditRepository
) {

    operator fun invoke(clientId: Int): Flow<List<CreditEntity>> {
        return creditRepository.getAllCredits(clientId)
    }
}