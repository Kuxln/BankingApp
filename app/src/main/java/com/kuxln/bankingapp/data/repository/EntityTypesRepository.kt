package com.kuxln.bankingapp.data.repository

import com.kuxln.bankingapp.data.room.dao.CreditTypeDAO
import com.kuxln.bankingapp.data.room.dao.DepositTypeDAO
import com.kuxln.bankingapp.data.room.dao.PurchaseTypeDAO
import com.kuxln.bankingapp.data.room.dao.RefillTypeDAO
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EntityTypesRepository @Inject constructor(
    private val purchaseTypeDAO: PurchaseTypeDAO,
    private val creditTypeDAO: CreditTypeDAO,
    private val depositTypeDAO: DepositTypeDAO,
    private val refillTypeDAO: RefillTypeDAO,
) {

    suspend fun inject() {
        purchaseTypeDAO.insert()
        creditTypeDAO.insert()
        depositTypeDAO.insert()
        refillTypeDAO.insert()
    }
}