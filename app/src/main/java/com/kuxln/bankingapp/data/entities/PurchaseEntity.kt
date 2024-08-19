package com.kuxln.bankingapp.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    tableName = "purchase",
    foreignKeys = [
        ForeignKey(
            entity = BankAccountEntity::class,
            parentColumns = arrayOf("bankAccountId"),
            childColumns = arrayOf("bankAccountId"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE,
        ),
        ForeignKey(
            entity = PurchaseTypeEntity::class,
            parentColumns = arrayOf("purchaseTypeName"),
            childColumns = arrayOf("purchaseTypeName"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE,
        )
    ]
)
data class PurchaseEntity(
    @PrimaryKey val purchaseId: Int,
    @ColumnInfo(name = "bank_account_id") val bankAccountId: Int,
    @ColumnInfo(name = "purchase_type_name") val purchaseTypeName: String,
    @ColumnInfo(name = "info") val info: String? = null,
    @ColumnInfo(name = "amount") val amount: Double,
    @ColumnInfo(name = "date") val date: Date,
)