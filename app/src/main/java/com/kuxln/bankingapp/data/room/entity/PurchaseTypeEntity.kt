package com.kuxln.bankingapp.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "purchase_type")
data class PurchaseTypeEntity(
    @PrimaryKey val purchaseTypeId: String,
    @ColumnInfo(name = "purchase_type_name") val purchaseTypeName: String,
)