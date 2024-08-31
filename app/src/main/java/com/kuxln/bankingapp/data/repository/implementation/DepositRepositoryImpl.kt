package com.kuxln.bankingapp.data.repository.implementation

import com.kuxln.bankingapp.data.repository.base.DepositRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DepositRepositoryImpl @Inject constructor(
    private val dao: com.kuxln.bankingapp.data.room.dao.DepositDAO
) : DepositRepository