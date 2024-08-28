package com.kuxln.bankingapp.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    tableName = "bank_account",
    foreignKeys = [
        ForeignKey(
            entity = ClientEntity::class,
            parentColumns = arrayOf("clientId"),
            childColumns = arrayOf("clientId"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE,
        )
    ]
)
data class BankAccountEntity(
    @PrimaryKey(autoGenerate = true) val bankAccountId: Int = 0,
    val clientId: Int,
    @ColumnInfo(name = "bank_account_number") val bankAccountNumber: Long,
    @ColumnInfo(name = "balance") val balance: Double = 0.0,
    @ColumnInfo(name = "start_date") val startDateMillis: Long,
    @ColumnInfo(name = "end_date") val endDateMillis: Long? = null,
    @ColumnInfo(name = "color_id") val colorId: Int = 0
)