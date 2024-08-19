package com.kuxln.bankingapp.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "client")
data class ClientEntity(
    @PrimaryKey(autoGenerate = true) val clientId: Int,
    @ColumnInfo(name = "last_name") val lastName: String,
    @ColumnInfo(name = "post_index") val firstName: String,
    @ColumnInfo(name = "address") val address: String,
    @ColumnInfo(name = "start_date") val startDate: Date,
    @ColumnInfo(name = "end_date") val endDate: Date? = null,
    @ColumnInfo(name = "credit_limit") val creditLimit: Int,
    @ColumnInfo(name = "is_operator") val isOperator: Boolean = false,
)