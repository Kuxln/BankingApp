package com.kuxln.bankingapp.data.repository.implementation

import com.kuxln.bankingapp.data.repository.base.CreditRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CreditRepositoryImpl @Inject constructor(
    private val dao: com.kuxln.bankingapp.data.room.dao.CreditDAO
) : CreditRepository