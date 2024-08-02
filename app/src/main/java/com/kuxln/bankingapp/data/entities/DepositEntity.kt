package com.kuxln.bankingapp.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    tableName = "deposit",
    foreignKeys = [
        ForeignKey(
            entity = BankAccountEntity::class,
            parentColumns = arrayOf("bankAccountId"),
            childColumns = arrayOf("bankAccountId"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE,
        ),
        ForeignKey(
            entity = DepositTypeEntity::class,
            parentColumns = arrayOf("depositTypeId"),
            childColumns = arrayOf("depositTypeId"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE,
        )
    ]
)
data class DepositEntity(
    @PrimaryKey(autoGenerate = true) val depositId: Long,
    @ColumnInfo(name = "bank_account_id") val bankAccountId: Long,
    @ColumnInfo(name = "deposit_type_id") val depositTypeId: Long,
    @ColumnInfo(name = "amount") val amount: Double,
    @ColumnInfo(name = "start_date") val startDate: Date,
    @ColumnInfo(name = "end_date") val endDate: Date? = null,
)