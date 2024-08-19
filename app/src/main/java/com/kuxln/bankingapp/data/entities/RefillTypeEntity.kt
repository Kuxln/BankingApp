package com.kuxln.bankingapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "refill_type")
data class RefillTypeEntity(
    @PrimaryKey(autoGenerate = true) val refillTypeName: String,
)