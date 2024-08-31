package com.kuxln.bankingapp.data.room.dao

import androidx.room.Dao
import androidx.room.Query

//insert into refill_type values(1,"Поповнення")
@Dao
interface RefillTypeDAO {

    @Query("insert into refill_type values(1,\"Поповнення\")")
    suspend fun insert()
}