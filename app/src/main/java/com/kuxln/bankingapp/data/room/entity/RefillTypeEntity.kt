package com.kuxln.bankingapp.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "refill_type")
data class RefillTypeEntity(
    @PrimaryKey val refillTypeName: String,
)