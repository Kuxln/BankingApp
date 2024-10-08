package com.kuxln.bankingapp.domain.usecases.bankaccount

import com.kuxln.bankingapp.data.repository.base.BankAccountRepository
import javax.inject.Inject

class CreateNewBankAccountUseCase @Inject constructor(
    private val bankAccountRepository: BankAccountRepository
) {
    suspend operator fun invoke(clientId: Int, colorId: Int) {
        bankAccountRepository.createBankAccount(clientId, colorId)
    }
}