package com.kuxln.bankingapp.data.repository.base

import com.kuxln.bankingapp.data.room.entity.BankAccountEntity
import kotlinx.coroutines.flow.Flow

interface BankAccountRepository {

    suspend fun countBankAccounts(): Int

    suspend fun getNewBankAccountNumber(): Long

    fun getAllBankAccounts(clientId: Int): Flow<List<BankAccountEntity>>

    fun getBankAccountByNumber(bankAccountNumber: Long): Flow<BankAccountEntity?>

    suspend fun refill(bankAccountId: Int, quantity: Double)

    suspend fun refill(bankAccountNumber: Long, quantity: Double)

    suspend fun withdraw(bankAccountId: Int, quantity: Double)

    suspend fun withdraw(bankAccountNumber: Long, quantity: Double)

    suspend fun createBankAccount(clientId: Int, colorId: Int)

    suspend fun closeBankAccount(bankAccountNumber: Long)

    suspend fun transfer(bankAccountNumberFrom: Long, bankAccountNumberTo: Long, quantity: Double)
}