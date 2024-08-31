package com.kuxln.bankingapp.domain.usecases.deposit

import com.kuxln.bankingapp.data.repository.base.BankAccountRepository
import com.kuxln.bankingapp.data.repository.base.DepositRepository
import javax.inject.Inject

class CreateDepositUseCase @Inject constructor(
    private val bankAccountRepository: BankAccountRepository,
    private val depositRepository: DepositRepository,
) {

    suspend operator fun invoke(bankAccountId: Int, quantity: Double, depositRate: Int) {
        bankAccountRepository.createDeposit(bankAccountId, quantity)
        depositRepository.createDeposit(bankAccountId, quantity, depositRate)
    }
}