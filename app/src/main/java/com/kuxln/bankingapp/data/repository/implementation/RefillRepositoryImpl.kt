package com.kuxln.bankingapp.data.repository.implementation

import com.kuxln.bankingapp.data.repository.base.RefillRepository
import com.kuxln.bankingapp.data.room.dao.RefillDAO
import com.kuxln.bankingapp.data.room.entity.RefillEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RefillRepositoryImpl @Inject constructor(
    private val dao: RefillDAO
) : RefillRepository {

    override suspend fun refill(bankAccountId: Int, quantity: Double) {
        dao.refill(
            RefillEntity(
                bankAccountId = bankAccountId,
                amount = quantity,
                refillTypeId = 1,
                dateMillis = System.currentTimeMillis()
            )
        )
    }
}