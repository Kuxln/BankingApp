package com.kuxln.bankingapp.data.repository.implementation

import com.kuxln.bankingapp.data.repository.base.BankAccountRepository
import com.kuxln.bankingapp.data.room.dao.BankAccountDAO
import com.kuxln.bankingapp.data.room.entity.BankAccountEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BankAccountRepositoryImpl @Inject constructor(
    private val dao: BankAccountDAO
) : BankAccountRepository {

    override suspend fun countBankAccounts(): Int = dao.countBankAccounts()

    override suspend fun getAllBankAccounts(clientId: Int): Flow<List<BankAccountEntity>> {
        return dao.getAllBankAccounts(clientId)
    }

    override suspend fun refill(bankAccountId: Int, quantity: Int) {
//        dao.refill(bankAccountId, quantity)
    }

    override suspend fun withdraw(bankAccountId: Int, quantity: Int) {
//        dao.withdraw(bankAccountId, quantity)
    }

    override suspend fun createBankAccount(clientId: Int) {
        val newBankAccount = BankAccountEntity(
            clientId = clientId,
            bankAccountNumber = 4149_0000_0000_0000 + countBankAccounts() + 1,
            startDateMillis = System.currentTimeMillis()
        )
        dao.createBankAccount(newBankAccount)
    }

    override suspend fun closeBankAccount(bankAccountNumber: Long) {
//        dao.closeBankAccount(clientId)
    }
}