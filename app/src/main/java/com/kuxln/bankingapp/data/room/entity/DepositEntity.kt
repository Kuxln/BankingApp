package com.kuxln.bankingapp.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    tableName = "deposit",
    foreignKeys = [
        ForeignKey(
            entity = ClientEntity::class,
            parentColumns = arrayOf("clientId"),
            childColumns = arrayOf("clientId"),
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
    @PrimaryKey(autoGenerate = true) val depositId: Int = 0,
    val clientId: Int,
    val depositTypeId: Int,
    @ColumnInfo(name = "amount") val amount: Double,
    @ColumnInfo(name = "start_date") val startDateMillis: Long,
    @ColumnInfo(name = "end_date") val endDateMillis: Long? = null,
)