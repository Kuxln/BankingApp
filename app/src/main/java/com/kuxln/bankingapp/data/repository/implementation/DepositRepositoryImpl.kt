package com.kuxln.bankingapp.data.repository.implementation

import com.kuxln.bankingapp.data.repository.base.DepositRepository
import com.kuxln.bankingapp.data.room.dao.DepositDAO
import com.kuxln.bankingapp.data.room.entity.DepositEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DepositRepositoryImpl @Inject constructor(
    private val dao: DepositDAO
) : DepositRepository {

    override suspend fun createDeposit(bankAccountId: Int, quantity: Double, depositRate: Int) {
        dao.createDeposit(
            DepositEntity(
                bankAccountId = bankAccountId,
                depositTypeId = 1,
                amount = quantity,
                startDateMillis = System.currentTimeMillis()
            )
        )
    }
}