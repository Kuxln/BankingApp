package com.kuxln.bankingapp.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "refill_type")
data class RefillTypeEntity(
    @PrimaryKey(autoGenerate = true) val refillTypeId: Long,
    @ColumnInfo(name = "refill_type_name") val refillTypeName: String,
)