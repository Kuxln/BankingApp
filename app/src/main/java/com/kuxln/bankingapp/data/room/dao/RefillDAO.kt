package com.kuxln.bankingapp.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import com.kuxln.bankingapp.data.room.entity.RefillEntity

@Dao
interface RefillDAO {

    @Insert
    fun refill(refillEntity: RefillEntity)
}
