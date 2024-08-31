package com.kuxln.bankingapp.domain.usecases.refill

import com.kuxln.bankingapp.data.repository.base.BankAccountRepository
import com.kuxln.bankingapp.data.repository.base.RefillRepository
import javax.inject.Inject

class RefillUseCase @Inject constructor(
    private val bankAccountRepository: BankAccountRepository,
    private val refillRepository: RefillRepository,
) {

    suspend operator fun invoke(bankAccountId: Int, quantity: Double) {
        bankAccountRepository.refill(bankAccountId, quantity)
        refillRepository.refill(bankAccountId, quantity)
    }
}