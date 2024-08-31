package com.kuxln.bankingapp.domain.usecases.credit

import com.kuxln.bankingapp.data.repository.base.BankAccountRepository
import com.kuxln.bankingapp.data.repository.base.CreditRepository
import javax.inject.Inject

class CreateCreditUseCase @Inject constructor(
    private val bankAccountRepository: BankAccountRepository,
    private val creditRepository: CreditRepository,
) {

    suspend operator fun invoke(bankAccountId: Int, quantity: Double, creditRate: Int) {
        bankAccountRepository.createCredit(bankAccountId, quantity)
        creditRepository.createCredit(bankAccountId, quantity, creditRate)
    }
}