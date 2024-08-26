package com.kuxln.bankingapp.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kuxln.bankingapp.data.room.entity.BankAccountEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BankAccountDAO {

    @Query("SELECT COUNT(*) FROM bank_account")
    suspend fun countBankAccounts(): Int

    @Query("SELECT * FROM bank_account WHERE clientId = :clientId")
    fun getAllBankAccounts(clientId: Int): Flow<List<BankAccountEntity>>
//
//    suspend fun refill(bankAccountId: Int, quantity: Int)
//
//    suspend fun withdraw(bankAccountId: Int, quantity: Int)

    @Insert
    suspend fun createBankAccount(bankAccount: BankAccountEntity)

    @Query("UPDATE bank_account SET end_date = :closeDateMillis WHERE bankAccountId = :bankAccountId")
    suspend fun closeBankAccount(bankAccountId: Int, closeDateMillis: Long)
}
