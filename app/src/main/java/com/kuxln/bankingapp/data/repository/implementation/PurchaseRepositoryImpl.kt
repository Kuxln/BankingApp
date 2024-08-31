package com.kuxln.bankingapp.data.repository.implementation

import com.kuxln.bankingapp.data.repository.base.PurchaseRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PurchaseRepositoryImpl @Inject constructor(
    private val dao: com.kuxln.bankingapp.data.room.dao.PurchaseDAO
) : PurchaseRepository