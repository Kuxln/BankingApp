package com.kuxln.bankingapp.data.repository.implementation

import com.kuxln.bankingapp.data.repository.base.BankAccountRepository
import com.kuxln.bankingapp.data.room.dao.BankAccountDAO
import com.kuxln.bankingapp.data.room.entity.BankAccountEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BankAccountRepositoryImpl @Inject constructor(
    private val dao: BankAccountDAO
): BankAccountRepository {

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
//        dao.createBankAccount(clientId)
    }

    override suspend fun closeBankAccount(bankAccountNumber: Long) {
//        dao.closeBankAccount(clientId)
    }
}