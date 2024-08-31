package com.kuxln.bankingapp.data.repository.implementation

import com.kuxln.bankingapp.data.repository.base.PurchaseTypeRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PurchaseTypeRepositoryImpl @Inject constructor(
    private val dao: com.kuxln.bankingapp.data.room.dao.PurchaseTypeDAO
) : PurchaseTypeRepository