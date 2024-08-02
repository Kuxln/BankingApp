package com.kuxln.bankingapp.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "purchase_type")
data class PurchaseTypeEntity(
    @PrimaryKey(autoGenerate = true) val purchaseTypeId: Long,
    @ColumnInfo(name = "purchase_type_name") val purchaseTypeName: String,
)