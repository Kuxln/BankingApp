package com.kuxln.bankingapp.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kuxln.bankingapp.data.room.entity.CreditEntity
import com.kuxln.bankingapp.data.room.entity.DepositEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CreditDAO {

    @Query("SELECT * FROM credit WHERE clientId = :clientId")
    fun getAllCredits(clientId: Int): Flow<List<CreditEntity>>

    @Insert
    fun createCredit(creditEntity: CreditEntity)
}