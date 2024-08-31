package com.kuxln.bankingapp.data.repository.base

import com.kuxln.bankingapp.data.room.entity.CreditEntity
import kotlinx.coroutines.flow.Flow

interface CreditRepository {

    fun getAllCredits(clientId: Int): Flow<List<CreditEntity>>

    suspend fun createCredit(clientId: Int, quantity: Double, creditRate: Int)
}