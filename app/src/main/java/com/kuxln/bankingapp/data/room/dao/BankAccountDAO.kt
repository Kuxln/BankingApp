package com.kuxln.bankingapp.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.kuxln.bankingapp.data.room.entity.BankAccountEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BankAccountDAO {

    @Query("SELECT COUNT(*) FROM bank_account")
    suspend fun countBankAccounts(): Int

    @Query("SELECT * FROM bank_account WHERE clientId = :clientId")
    fun getAllBankAccounts(clientId: Int): Flow<List<BankAccountEntity>>

    @Query("SELECT * FROM bank_account WHERE bank_account_number = :bankAccountNumber")
    suspend fun getBankAccountByNumber(bankAccountNumber: Long): BankAccountEntity?

    @Query("UPDATE bank_account SET balance = balance + :quantity WHERE bankAccountId = :bankAccountId")
    suspend fun refill(bankAccountId: Int, quantity: Double)

    @Query("UPDATE bank_account SET balance = balance + :quantity WHERE bank_account_number = :bankAccountNumber")
    suspend fun refill(bankAccountNumber: Long, quantity: Double)

    @Query("UPDATE bank_account SET balance = balance - :quantity WHERE bankAccountId = :bankAccountId")
    suspend fun withdraw(bankAccountId: Int, quantity: Double)

    @Query("UPDATE bank_account SET balance = balance - :quantity WHERE bank_account_number = :bankAccountNumber")
    suspend fun withdraw(bankAccountNumber: Long, quantity: Double)

    @Insert
    suspend fun createBankAccount(bankAccount: BankAccountEntity)

    @Query("UPDATE bank_account SET end_date = :closeDateMillis WHERE bankAccountId = :bankAccountId")
    suspend fun closeBankAccount(bankAccountId: Int, closeDateMillis: Long)

    @Transaction
    suspend fun transfer(bankAccountNumberFrom: Long, bankAccountNumberTo: Long, quantity: Double) {
        withdraw(bankAccountNumberFrom, quantity)
        refill(bankAccountNumberTo, quantity)
    }
}
