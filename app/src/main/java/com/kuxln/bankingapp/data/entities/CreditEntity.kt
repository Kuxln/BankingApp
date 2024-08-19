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
            parentColumns = arrayOf("creditTypeName"),
            childColumns = arrayOf("creditTypeName"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE,
        )
    ]
)
data class CreditEntity(
    @PrimaryKey(autoGenerate = true) val creditId: Int,
    @ColumnInfo(name = "bank_account_id") val bankAccountId: Int,
    @ColumnInfo(name = "credit_type_name") val creditTypeName: String,
    @ColumnInfo(name = "cost") val cost: Double,
    @ColumnInfo(name = "start_date") val startDate: Date,
    @ColumnInfo(name = "end_date") val endDate: Date,
)