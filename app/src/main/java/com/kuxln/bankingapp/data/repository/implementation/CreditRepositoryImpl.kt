package com.kuxln.bankingapp.data.repository.implementation

import com.kuxln.bankingapp.data.repository.base.CreditRepository
import com.kuxln.bankingapp.data.room.dao.CreditDAO
import com.kuxln.bankingapp.data.room.entity.CreditEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CreditRepositoryImpl @Inject constructor(
    private val dao: CreditDAO
) : CreditRepository {

    override suspend fun createCredit(bankAccountId: Int, quantity: Double, creditRate: Int) {
        dao.createCredit(
            CreditEntity(
                bankAccountId = bankAccountId,
                creditTypeId = 1,
                cost = quantity,
                startDateMillis = System.currentTimeMillis(),
            )
        )
    }
}