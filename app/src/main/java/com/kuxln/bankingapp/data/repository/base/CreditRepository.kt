package com.kuxln.bankingapp.data.repository.base

interface CreditRepository {

    suspend fun createCredit(bankAccountId: Int, quantity: Double, creditRate: Int)
}