package com.kuxln.bankingapp.data.repository.base

interface PurchaseRepository {

    suspend fun withdraw(bankAccountId: Int, quantity: Double)
}