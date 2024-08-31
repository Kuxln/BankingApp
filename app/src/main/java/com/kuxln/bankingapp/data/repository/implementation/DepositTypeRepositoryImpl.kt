package com.kuxln.bankingapp.data.repository.implementation

import com.kuxln.bankingapp.data.repository.base.DepositTypeRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DepositTypeRepositoryImpl @Inject constructor(
    private val dao: com.kuxln.bankingapp.data.room.dao.DepositTypeDAO
) : DepositTypeRepository