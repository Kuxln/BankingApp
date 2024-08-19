package com.kuxln.bankingapp.data.repository.implementation

import com.kuxln.bankingapp.data.dao.PurchaseDAO
import com.kuxln.bankingapp.data.repository.base.PurchaseRepository
import javax.inject.Inject

class PurchaseRepositoryImpl @Inject constructor(
    private val dao: PurchaseDAO
) : PurchaseRepository