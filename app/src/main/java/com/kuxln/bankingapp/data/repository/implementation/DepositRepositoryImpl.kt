package com.kuxln.bankingapp.data.repository.implementation

import com.kuxln.bankingapp.data.repository.base.DepositRepository
import com.kuxln.bankingapp.data.room.dao.DepositDAO
import com.kuxln.bankingapp.data.room.entity.DepositEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DepositRepositoryImpl @Inject constructor(
    private val dao: DepositDAO
) : DepositRepository {

    override fun getAllDeposits(clientId: Int): Flow<List<DepositEntity>> {
        return dao.getAllDeposits(clientId)
    }

    override suspend fun createDeposit(clientId: Int, quantity: Double, depositRate: Int) {
        dao.createDeposit(
            DepositEntity(
                clientId = clientId,
                depositTypeId = 1,
                amount = quantity,
                startDateMillis = System.currentTimeMillis()
            )
        )
    }
}