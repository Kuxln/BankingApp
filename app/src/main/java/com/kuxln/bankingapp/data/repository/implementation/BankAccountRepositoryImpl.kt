package com.kuxln.bankingapp.data.repository.implementation

import com.kuxln.bankingapp.data.room.dao.BankAccountDAO
import com.kuxln.bankingapp.data.repository.base.BankAccountRepository
import javax.inject.Inject

class BankAccountRepositoryImpl @Inject constructor(
    private val dao: com.kuxln.bankingapp.data.room.dao.BankAccountDAO
): BankAccountRepository {

}