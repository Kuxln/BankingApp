package com.kuxln.bankingapp.data.repository.implementation

import com.kuxln.bankingapp.data.repository.base.CreditRepository
import com.kuxln.bankingapp.data.room.dao.CreditDAO
import com.kuxln.bankingapp.data.room.entity.CreditEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CreditRepositoryImpl @Inject constructor(
    private val dao: CreditDAO
) : CreditRepository {

    override fun getAllCredits(clientId: Int): Flow<List<CreditEntity>> {
        return dao.getAllCredits(clientId)
    }

    override suspend fun createCredit(clientId: Int, quantity: Double, creditRate: Int) {
        dao.createCredit(
            CreditEntity(
                clientId = clientId,
                creditTypeId = 1,
                cost = quantity,
                startDateMillis = System.currentTimeMillis(),
            )
        )
    }
}