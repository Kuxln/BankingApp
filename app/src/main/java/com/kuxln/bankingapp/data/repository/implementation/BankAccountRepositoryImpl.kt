package com.kuxln.bankingapp.data.repository.implementation

import com.kuxln.bankingapp.data.repository.base.BankAccountRepository
import com.kuxln.bankingapp.data.room.dao.BankAccountDAO
import com.kuxln.bankingapp.data.room.entity.BankAccountEntity
import com.kuxln.bankingapp.data.room.exception.BankAccountNotExistsException
import com.kuxln.bankingapp.data.room.exception.NotEnoughMoneyException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BankAccountRepositoryImpl @Inject constructor(
    private val dao: BankAccountDAO
) : BankAccountRepository {

    override suspend fun countBankAccounts(): Int = dao.countBankAccounts()

    override suspend fun getNewBankAccountNumber(): Long = 4149_6090_0000_0000 + countBankAccounts() + 1

    override fun getAllBankAccounts(clientId: Int): Flow<List<BankAccountEntity>> {
        return dao.getAllBankAccounts(clientId)
    }

    override fun getBankAccountByNumber(bankAccountNumber: Long): Flow<BankAccountEntity?> {
        return flow { emit(dao.getBankAccountByNumber(bankAccountNumber)) }
    }

    override suspend fun refill(bankAccountId: Int, quantity: Double) {
        dao.refill(bankAccountId, quantity)
    }

    override suspend fun refill(bankAccountNumber: Long, quantity: Double) {
        dao.refill(bankAccountNumber, quantity)
    }

    override suspend fun withdraw(bankAccountId: Int, quantity: Double) {
        dao.withdraw(bankAccountId, quantity)
    }

    override suspend fun withdraw(bankAccountNumber: Long, quantity: Double) {
        dao.withdraw(bankAccountNumber, quantity)
    }

    override suspend fun createBankAccount(clientId: Int, colorId: Int) {
        val newBankAccount = BankAccountEntity(
            clientId = clientId,
            bankAccountNumber = 4149_0000_0000_0000 + countBankAccounts() + 1,
            startDateMillis = System.currentTimeMillis(),
            colorId = colorId
        )
        dao.createBankAccount(newBankAccount)
    }

    override suspend fun closeBankAccount(bankAccountNumber: Long) {
        //todo
        //dao.closeBankAccount(bankAccountNumber, System.currentTimeMillis())
    }

    override suspend fun transfer(
        bankAccountNumberFrom: Long,
        bankAccountNumberTo: Long,
        quantity: Double
    ) {
        val bankAccountFrom = dao.getBankAccountByNumber(bankAccountNumberFrom)
        bankAccountFrom?.let {
            if (bankAccountFrom.balance < quantity) throw NotEnoughMoneyException()
            val bankAccountTo = dao.getBankAccountByNumber(bankAccountNumberTo)
            bankAccountTo?.let {
                dao.transfer(bankAccountNumberFrom, bankAccountNumberTo, quantity)
            } ?: throw BankAccountNotExistsException(bankAccountNumberTo.toString())
        } ?: throw BankAccountNotExistsException(bankAccountNumberFrom.toString())
    }
}