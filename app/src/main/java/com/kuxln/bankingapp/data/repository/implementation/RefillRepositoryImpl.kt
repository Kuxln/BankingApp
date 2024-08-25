package com.kuxln.bankingapp.data.repository.implementation

import com.kuxln.bankingapp.data.repository.base.RefillRepository
import javax.inject.Inject

class RefillRepositoryImpl @Inject constructor(
    private val dao: com.kuxln.bankingapp.data.room.dao.RefillDAO
) : RefillRepository