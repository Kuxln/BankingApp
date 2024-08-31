package com.kuxln.bankingapp.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "refill_type")
data class RefillTypeEntity(
    @PrimaryKey val refillTypeId: Int,
    @ColumnInfo(name = "refill_type_name") val refillTypeName: String,
)