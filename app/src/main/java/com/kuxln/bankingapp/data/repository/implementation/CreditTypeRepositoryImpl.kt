package com.kuxln.bankingapp.data.repository.implementation

import com.kuxln.bankingapp.data.repository.base.CreditTypeRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CreditTypeRepositoryImpl @Inject constructor(
    private val dao: com.kuxln.bankingapp.data.room.dao.CreditTypeDAO
) : CreditTypeRepository