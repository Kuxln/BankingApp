package com.kuxln.bankingapp.data.room.dao

import androidx.room.Dao
import androidx.room.Query

//insert into purchase_type values(1,"Зняття грошей")
@Dao
interface PurchaseTypeDAO {

    @Query("insert into purchase_type values(1,\"Зняття грошей\")")
    fun insert()
}