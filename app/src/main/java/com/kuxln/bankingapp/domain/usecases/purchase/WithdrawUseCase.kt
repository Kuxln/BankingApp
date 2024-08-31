package com.kuxln.bankingapp.domain.usecases.purchase

import com.kuxln.bankingapp.data.repository.base.BankAccountRepository
import com.kuxln.bankingapp.data.repository.base.PurchaseRepository
import javax.inject.Inject

class WithdrawUseCase @Inject constructor(
    private val bankAccountRepository: BankAccountRepository,
    private val purchaseRepository: PurchaseRepository,
) {

    suspend operator fun invoke(bankAccountId: Int, quantity: Double) {
        bankAccountRepository.withdraw(bankAccountId, quantity)
        purchaseRepository.withdraw(bankAccountId, quantity)
    }
}