package com.kuxln.bankingapp.data.repository.implementation

import com.kuxln.bankingapp.data.repository.base.PurchaseRepository
import com.kuxln.bankingapp.data.room.dao.PurchaseDAO
import com.kuxln.bankingapp.data.room.entity.PurchaseEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PurchaseRepositoryImpl @Inject constructor(
    private val dao: PurchaseDAO
) : PurchaseRepository {

    override suspend fun withdraw(bankAccountId: Int, quantity: Double) {
        dao.withdraw(
            PurchaseEntity(
                bankAccountId = bankAccountId,
                purchaseTypeId = 1,
                amount = quantity,
                dateMillis = System.currentTimeMillis()
            )
        )
    }
}