package com.kuxln.bankingapp.data.repository.implementation

import com.kuxln.bankingapp.data.dao.DepositTypeDAO
import com.kuxln.bankingapp.data.repository.base.DepositTypeRepository
import javax.inject.Inject

class DepositTypeRepositoryImpl @Inject constructor(
    private val dao: DepositTypeDAO
) : DepositTypeRepository