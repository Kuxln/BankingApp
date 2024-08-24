package com.kuxln.bankingapp.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "deposit_type")
data class DepositTypeEntity(
    @PrimaryKey val depositTypeName: String,
    @ColumnInfo(name = "deposit_rate") val depositRate: Double,
)