package com.kuxln.bankingapp.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import com.kuxln.bankingapp.data.room.entity.CreditEntity

@Dao
interface CreditDAO {

    @Insert
    fun createCredit(creditEntity: CreditEntity)
}