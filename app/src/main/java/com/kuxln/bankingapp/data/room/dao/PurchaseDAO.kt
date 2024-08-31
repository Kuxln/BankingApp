package com.kuxln.bankingapp.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import com.kuxln.bankingapp.data.room.entity.PurchaseEntity

@Dao
interface PurchaseDAO {

    @Insert
    fun withdraw(purchaseEntity: PurchaseEntity)
}