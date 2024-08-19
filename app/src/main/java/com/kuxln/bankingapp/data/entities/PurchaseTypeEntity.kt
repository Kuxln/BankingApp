package com.kuxln.bankingapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "purchase_type")
data class PurchaseTypeEntity(
    @PrimaryKey(autoGenerate = true) val purchaseTypeName: String,
)