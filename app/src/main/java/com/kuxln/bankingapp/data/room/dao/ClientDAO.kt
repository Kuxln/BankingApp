package com.kuxln.bankingapp.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kuxln.bankingapp.data.room.entity.ClientEntity

//insert into client values(1, "login", "password", 0,"Kulesh", "Andrii", 0, "address", 0, 0, 0, 0)
@Dao
interface ClientDAO {

    @Insert
    suspend fun createClient(client: ClientEntity)

    @Query("SELECT * FROM client WHERE login = :login AND password = :password")
    suspend fun findClientByLoginAndPassword(login: String, password: String): ClientEntity?

    @Query("SELECT * FROM client WHERE login = :login")
    suspend fun findClientByLogin(login: String): ClientEntity?

    @Query("SELECT * FROM client WHERE clientId = :clientId")
    suspend fun findClientById(clientId: Int): ClientEntity?

    @Query("UPDATE client SET login = :login, phone_number = :phoneNumber, last_name = :lastName, first_name = :firstName, post_index = :postIndex, address = :address, credit_limit = :creditLimit WHERE clientId = :clientId")
    suspend fun updateClient(
        clientId: Int,
        login: String,
        phoneNumber: String,
        lastName: String,
        firstName: String,
        postIndex: Int,
        address: String,
        creditLimit: Int,
    )

    @Query("UPDATE client SET end_date = :closeDateMillis WHERE clientId = :clientId")
    suspend fun closeClientById(clientId: Int, closeDateMillis: Long)
}
