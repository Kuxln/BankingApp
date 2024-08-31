package com.kuxln.bankingapp.domain.usecases.bankaccount

import com.kuxln.bankingapp.data.repository.base.BankAccountRepository
import javax.inject.Inject

class GetNewBankAccountNumberUseCase @Inject constructor(
    private val bankAccountRepository: BankAccountRepository
) {

    suspend operator fun invoke(): Long {
        return bankAccountRepository.getNewBankAccountNumber()
    }
}