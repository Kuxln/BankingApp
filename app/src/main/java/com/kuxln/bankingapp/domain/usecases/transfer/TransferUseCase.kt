package com.kuxln.bankingapp.domain.usecases.transfer

import com.kuxln.bankingapp.data.repository.base.BankAccountRepository
import javax.inject.Inject

class TransferUseCase @Inject constructor(
    private val bankAccountRepository: BankAccountRepository
) {

    suspend operator fun invoke(bankAccountNumberFrom: Long, bankAccountNumberTo: Long, quantity: Double) {
        bankAccountRepository.transfer(bankAccountNumberFrom, bankAccountNumberTo, quantity)
    }
}