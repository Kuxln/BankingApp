package com.kuxln.bankingapp.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "credit_type")
data class CreditTypeEntity(
    @PrimaryKey val creditTypeId: Int,
    @ColumnInfo(name = "credit_type_name") val creditTypeName: String,
    @ColumnInfo(name = "credit_rate") val creditRate: Double,
)