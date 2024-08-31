package com.kuxln.bankingapp.data.room.entity

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
            parentColumns = arrayOf("purchaseTypeId"),
            childColumns = arrayOf("purchaseTypeId"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE,
        )
    ]
)
data class PurchaseEntity(
    @PrimaryKey val purchaseId: Int = 0,
    val bankAccountId: Int,
    val purchaseTypeId: Int,
    @ColumnInfo(name = "info") val info: String? = null,
    @ColumnInfo(name = "amount") val amount: Double,
    @ColumnInfo(name = "date") val dateMillis: Long,
)