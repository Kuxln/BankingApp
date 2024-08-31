package com.kuxln.bankingapp.data.repository.base

interface RefillRepository {

    suspend fun refill(bankAccountId: Int, quantity: Double)
}