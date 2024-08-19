package com.kuxln.bankingapp.data.repository.implementation

import com.kuxln.bankingapp.data.dao.PurchaseTypeDAO
import com.kuxln.bankingapp.data.repository.base.PurchaseTypeRepository
import javax.inject.Inject

class PurchaseTypeRepositoryImpl @Inject constructor(
    private val dao: PurchaseTypeDAO
) : PurchaseTypeRepository