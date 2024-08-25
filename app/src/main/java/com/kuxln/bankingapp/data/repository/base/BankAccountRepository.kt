package com.kuxln.bankingapp.data.repository.base

import com.kuxln.bankingapp.data.room.entity.BankAccountEntity
import kotlinx.coroutines.flow.Flow

interface BankAccountRepository {

    suspend fun getAllBankAccounts(clientId: Int): Flow<List<BankAccountEntity>>

    suspend fun refill(bankAccountId: Int, quantity: Int)

    suspend fun withdraw(bankAccountId: Int,quantity: Int)

    suspend fun createBankAccount(clientId: Int)

    suspend fun closeBankAccount(bankAccountNumber: Long)
}