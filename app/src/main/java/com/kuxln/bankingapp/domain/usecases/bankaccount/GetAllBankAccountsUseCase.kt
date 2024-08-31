package com.kuxln.bankingapp.domain.usecases.bankaccount

import com.kuxln.bankingapp.data.repository.base.BankAccountRepository
import com.kuxln.bankingapp.data.room.entity.BankAccountEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllBankAccountsUseCase @Inject constructor(
    private val bankAccountRepository: BankAccountRepository
) {

    operator fun invoke(clientId: Int): Flow<List<BankAccountEntity>> {
        return bankAccountRepository.getAllBankAccounts(clientId)
    }
}