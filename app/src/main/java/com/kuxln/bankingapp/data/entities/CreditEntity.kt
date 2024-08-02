package com.kuxln.bankingapp.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    tableName = "credit",
    foreignKeys = [
        ForeignKey(
            entity = BankAccountEntity::class,
            parentColumns = arrayOf("bankAccountId"),
            childColumns = arrayOf("bankAccountId"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE,
        ),
        ForeignKey(
            entity = CreditTypeEntity::class,
            parentColumns = arrayOf("creditTypeId"),
            childColumns = arrayOf("creditTypeId"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE,
        )
    ]
)
data class CreditEntity(
    @PrimaryKey(autoGenerate = true) val creditId: Long,
    @ColumnInfo(name = "bank_account_id") val bankAccountId: Long,
    @ColumnInfo(name = "credit_type_id") val creditTypeId: Long,
    @ColumnInfo(name = "cost") val cost: Double,
    @ColumnInfo(name = "start_date") val startDate: Date,
    @ColumnInfo(name = "end_date") val endDate: Date,
)