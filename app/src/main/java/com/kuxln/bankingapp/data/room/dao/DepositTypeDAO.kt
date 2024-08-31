package com.kuxln.bankingapp.data.room.dao

import androidx.room.Dao
import androidx.room.Query

//@Query("insert into deposit_type values(1, \"Стандарт\", 10)")
@Dao
interface DepositTypeDAO {

    @Query("insert into deposit_type values(1, \"Стандарт\", 10)")
    suspend fun insert()
}