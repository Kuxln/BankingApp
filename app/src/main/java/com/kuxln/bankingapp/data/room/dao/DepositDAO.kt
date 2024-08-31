package com.kuxln.bankingapp.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import com.kuxln.bankingapp.data.room.entity.DepositEntity

@Dao
interface DepositDAO {

    @Insert
    fun createDeposit(depositEntity: DepositEntity)
}