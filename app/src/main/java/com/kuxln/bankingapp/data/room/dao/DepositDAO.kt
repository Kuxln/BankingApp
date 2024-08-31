package com.kuxln.bankingapp.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kuxln.bankingapp.data.room.entity.DepositEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DepositDAO {

    @Query("SELECT * FROM deposit WHERE clientId = :clientId")
    fun getAllDeposits(clientId: Int): Flow<List<DepositEntity>>

    @Insert
    fun createDeposit(depositEntity: DepositEntity)
}