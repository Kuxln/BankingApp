package com.kuxln.bankingapp.data.room.dao

import androidx.room.Dao
import androidx.room.Query

// insert into deposit_type values(1, 10, "Стандарт")
@Dao
interface DepositTypeDAO {

    @Query("insert into deposit_type values(1, 10, \"Стандарт\")")
    fun insert()
}