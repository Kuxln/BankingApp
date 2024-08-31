package com.kuxln.bankingapp.data.repository.implementation

import com.kuxln.bankingapp.data.repository.base.RefillTypeRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RefillTypeRepositoryImpl @Inject constructor(
    private val dao: com.kuxln.bankingapp.data.room.dao.RefillTypeDAO
) : RefillTypeRepository