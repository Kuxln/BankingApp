package com.kuxln.bankingapp.data.entities

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
    @PrimaryKey(autoGenerate = true) val bankAccountId: Long,
    @ColumnInfo(name = "client_id") val clientId: Long,
    @ColumnInfo(name = "balance") val balance: Double = 0.0,
    @ColumnInfo(name = "start_date") val startDate: Date,
    @ColumnInfo(name = "end_date") val endDate: Date? = null,
)