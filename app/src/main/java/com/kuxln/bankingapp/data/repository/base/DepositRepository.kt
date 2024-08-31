package com.kuxln.bankingapp.data.repository.base

interface DepositRepository {

    suspend fun createDeposit(bankAccountId: Int, quantity: Double, depositRate: Int)
}