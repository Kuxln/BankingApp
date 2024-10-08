package com.kuxln.bankingapp.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "client")
data class ClientEntity(
    @PrimaryKey(autoGenerate = true) val clientId: Int = 0,
    @ColumnInfo(name = "login") val login: String,
    @ColumnInfo(name = "password") val password: String,
    @ColumnInfo(name = "phone_number") val phoneNumber: String = "",
    @ColumnInfo(name = "last_name") val lastName: String = "",
    @ColumnInfo(name = "first_name") val firstName: String = "",
    @ColumnInfo(name = "post_index") val postIndex: Int? = null,
    @ColumnInfo(name = "address") val address: String = "",
    @ColumnInfo(name = "start_date") val startDateMillis: Long,
    @ColumnInfo(name = "end_date") val endDateMillis: Long? = null,
    @ColumnInfo(name = "credit_limit") val creditLimit: Int = 10000,
    @ColumnInfo(name = "is_operator") val isOperator: Boolean = false,
)