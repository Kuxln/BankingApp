package com.kuxln.bankingapp.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    tableName = "refill",
    foreignKeys = [
        ForeignKey(
            entity = BankAccountEntity::class,
            parentColumns = arrayOf("bankAccountId"),
            childColumns = arrayOf("bankAccountId"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE,
        ),
        ForeignKey(
            entity = RefillTypeEntity::class,
            parentColumns = arrayOf("refillTypeId"),
            childColumns = arrayOf("refillTypeId"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE,
        )
    ]
)
data class RefillEntity(
    @PrimaryKey val refillId: Long,
    @ColumnInfo(name = "bank_account_id") val bankAccountId: Long,
    @ColumnInfo(name = "refill_type_id") val refillTypeId: Long,
    @ColumnInfo(name = "info") val info: String? = null,
    @ColumnInfo(name = "amount") val amount: Double,
    @ColumnInfo(name = "date") val date: Date,
)