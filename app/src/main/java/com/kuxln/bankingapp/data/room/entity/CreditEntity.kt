package com.kuxln.bankingapp.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    tableName = "credit",
    foreignKeys = [
        ForeignKey(
            entity = ClientEntity::class,
            parentColumns = arrayOf("clientId"),
            childColumns = arrayOf("clientId"),
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
    @PrimaryKey(autoGenerate = true) val creditId: Int = 0,
    val clientId: Int,
    val creditTypeId: Int,
    @ColumnInfo(name = "cost") val cost: Double,
    @ColumnInfo(name = "start_date") val startDateMillis: Long,
    @ColumnInfo(name = "end_date") val endDateMillis: Long? = null,
)