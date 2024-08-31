package com.kuxln.bankingapp.data.repository.base

import com.kuxln.bankingapp.data.room.entity.DepositEntity
import kotlinx.coroutines.flow.Flow

interface DepositRepository {

    fun getAllDeposits(clientId: Int): Flow<List<DepositEntity>>

    suspend fun createDeposit(clientId: Int, quantity: Double, depositRate: Int)
}