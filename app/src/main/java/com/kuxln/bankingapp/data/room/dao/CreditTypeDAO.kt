package com.kuxln.bankingapp.data.room.dao

import androidx.room.Dao
import androidx.room.Query

//@Query("insert into credit_type values(1, \"Стандарт\", 16)")
@Dao
interface CreditTypeDAO {

    @Query("insert into credit_type values(1, \"Стандарт\", 16)")
    suspend fun insert()
}