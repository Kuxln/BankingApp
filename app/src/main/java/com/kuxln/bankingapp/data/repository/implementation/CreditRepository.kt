package com.kuxln.bankingapp.data.repository.implementation

import com.kuxln.bankingapp.data.dao.CreditDAO
import com.kuxln.bankingapp.data.repository.base.CreditRepository
import javax.inject.Inject

class CreditRepositoryImpl @Inject constructor(
    private val dao: CreditDAO
) : CreditRepository