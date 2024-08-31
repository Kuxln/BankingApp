package com.kuxln.bankingapp.data.room.dao

import androidx.room.Dao
import androidx.room.Query

//insert into credit_type values(1, 16, "Стандарт")
@Dao
interface CreditTypeDAO {

    @Query("insert into credit_type values(1, 16, \"Стандарт\")")
    fun insert()
}