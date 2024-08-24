package com.kuxln.bankingapp.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "credit_type")
data class CreditTypeEntity(
    @PrimaryKey val creditTypeName: String,
    @ColumnInfo(name = "credit_rate") val creditRate: Double,
)