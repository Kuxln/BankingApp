package com.kuxln.bankingapp.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "credit_type")
data class CreditTypeEntity(
    @PrimaryKey(autoGenerate = true) val creditTypeName: String,
    @ColumnInfo(name = "credit_rate") val creditRate: Double,
)